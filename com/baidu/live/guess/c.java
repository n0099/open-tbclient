package com.baidu.live.guess;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.data.AlaGuessQuesData;
import com.baidu.live.guess.http.GuessUploadAnswerResponseMessage;
import com.baidu.live.guess.http.GuessVoucherHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private CustomMessageListener bel;
    private AlaGuessQuesData bem;
    private AlaGuessQuesData ben;
    private InterfaceC0183c beo;
    private b ber;
    private a bes;
    private String bep = "https://quanmin.baidu.com/pubshow/task/Getquizticket";
    private String beq = "https://quanmin.baidu.com/pubshow/subject/answer";
    private volatile int beu = -1;
    private final Object mLock = new Object();
    private HttpMessageListener bev = new HttpMessageListener(1021215) { // from class: com.baidu.live.guess.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuessVoucherHttpResponseMessage)) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (c.this.ber != null) {
                        c.this.ber.onFailure(httpResponsedMessage.getError());
                        return;
                    }
                    return;
                }
                GuessVoucherHttpResponseMessage guessVoucherHttpResponseMessage = (GuessVoucherHttpResponseMessage) httpResponsedMessage;
                if (c.this.ber != null) {
                    c.this.ber.d(guessVoucherHttpResponseMessage.getVoucherNum(), guessVoucherHttpResponseMessage.getTaskUrl(), guessVoucherHttpResponseMessage.isFollow());
                }
            }
        }
    };
    private HttpMessageListener bew = new HttpMessageListener(1021218) { // from class: com.baidu.live.guess.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessUploadAnswerResponseMessage guessUploadAnswerResponseMessage = (GuessUploadAnswerResponseMessage) httpResponsedMessage;
            if (guessUploadAnswerResponseMessage.getStatusCode() != 200 || c.this.getErrorCode() != 0) {
                c.this.bes.onFailure(httpResponsedMessage.getStatusCode(), httpResponsedMessage.getErrorString());
            } else if (c.this.bes != null) {
                if (guessUploadAnswerResponseMessage.getStatus() == 0) {
                    c.this.bes.Kc();
                } else {
                    c.this.bes.onFailure(guessUploadAnswerResponseMessage.getStatus(), guessUploadAnswerResponseMessage.getMsg());
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Kc();

        void onFailure(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void d(int i, String str, boolean z);

        void onFailure(int i);
    }

    /* renamed from: com.baidu.live.guess.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0183c {
        void a(AlaGuessQuesData alaGuessQuesData);

        void b(AlaGuessQuesData alaGuessQuesData);
    }

    public c(InterfaceC0183c interfaceC0183c) {
        this.beo = interfaceC0183c;
    }

    public void JY() {
        if (this.bel == null) {
            this.bel = new CustomMessageListener(2913246) { // from class: com.baidu.live.guess.c.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        List<String> list = (List) customResponsedMessage.getData();
                        if (list.size() != 0 && c.this.Kb() != -1 && c.this.Kb() != 2) {
                            for (String str : list) {
                                try {
                                    jSONObject = new JSONObject(str);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (!jSONObject.optString("room_id").equals("")) {
                                    long parseLong = Long.parseLong(jSONObject.optString("room_id"));
                                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("content"));
                                    String optString = jSONObject2.optString("content_type");
                                    if (TextUtils.equals(optString, AlaGuessQuesData.ANSWER_INFO)) {
                                        c.this.b(jSONObject2, parseLong);
                                        c.this.beo.b(c.this.ben);
                                    } else if (TextUtils.equals(optString, "subject_mi_info")) {
                                        c.this.a(jSONObject2, parseLong);
                                        c.this.beo.a(c.this.bem);
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            };
        }
        registerListener(this.bel);
        registerListener(this.bev);
        registerListener(this.bew);
        Ka();
        JZ();
    }

    private void JZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021218, this.beq);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessUploadAnswerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Ka() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021215, this.bep);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessVoucherHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void eH(int i) {
        this.beu = i;
    }

    public int Kb() {
        return this.beu;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, long j) {
        if (this.bem == null) {
            this.bem = new AlaGuessQuesData();
        }
        this.bem.setRoomId(j);
        this.bem.setQuesContent(jSONObject.optString("ques_content"));
        this.bem.setQuesId(jSONObject.optLong("ques_id"));
        this.bem.setAnswerInfo(jSONObject.optString(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bem.setAnswerTime(jSONObject.optInt("answer_time"));
        this.bem.setAmount(JavaTypesHelper.toInt(jSONObject.optString(LogConfig.LOG_AMOUNT), 0));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bem.setFirstOpt(split[0]);
        this.bem.setSecondOpt(split[1]);
        this.bem.setAnchorId(JavaTypesHelper.toLong(jSONObject.optString("anchor_uid"), 0L));
        this.bem.setContentType("subject_mi_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, long j) {
        if (this.ben == null) {
            this.ben = new AlaGuessQuesData();
        }
        this.ben.setRoomId(j);
        this.ben.setAnswer(jSONObject.optInt(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.ben.setTotalNum(JavaTypesHelper.toLong(jSONObject.optString("total_number"), 0L));
        this.ben.setCorrectNum(JavaTypesHelper.toLong(jSONObject.optString("currect_number"), 0L));
        this.ben.setCorrectPercent(JavaTypesHelper.toDouble(jSONObject.optString("currect_percent"), 0.0d));
        this.ben.setAmount(JavaTypesHelper.toLong(jSONObject.optString(LogConfig.LOG_AMOUNT), 0L));
        this.ben.setAverage(JavaTypesHelper.toFloat(jSONObject.optString("average_amount"), 0.0f));
        this.ben.setQuesContent(jSONObject.optString("ques_content"));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.ben.setFirstOpt(split[0]);
        this.ben.setSecondOpt(split[1]);
        this.ben.setQuesId(JavaTypesHelper.toLong(jSONObject.optString("ques_id"), 0L));
        this.ben.setContentType(AlaGuessQuesData.ANSWER_INFO);
    }

    public void JT() {
        this.beu = -1;
    }

    public void onDestroy() {
        if (this.bem != null) {
            this.bem.reset();
        }
        if (this.ben != null) {
            this.ben.reset();
        }
        MessageManager.getInstance().unRegisterListener(this.bel);
        MessageManager.getInstance().unRegisterListener(this.bev);
        MessageManager.getInstance().unRegisterTask(1021215);
    }

    public void a(long j, int i, b bVar) {
        this.ber = bVar;
        com.baidu.live.guess.http.b bVar2 = new com.baidu.live.guess.http.b();
        bVar2.setUserId(j);
        bVar2.eI(i);
        MessageManager.getInstance().sendMessage(bVar2);
    }

    public void a(long j, long j2, int i, a aVar) {
        this.bes = aVar;
        com.baidu.live.guess.http.a aVar2 = new com.baidu.live.guess.http.a();
        aVar2.setUserId(j);
        aVar2.setAnswer(i);
        aVar2.setQuesId(j2);
        aVar2.setCuid(TbadkCoreApplication.getInst().getCuid());
        MessageManager.getInstance().sendMessage(aVar2);
    }
}
