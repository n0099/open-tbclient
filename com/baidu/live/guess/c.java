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
    private CustomMessageListener bfj;
    private AlaGuessQuesData bfk;
    private AlaGuessQuesData bfl;
    private InterfaceC0184c bfm;
    private b bfp;
    private a bfq;
    private String bfn = "https://quanmin.baidu.com/pubshow/task/Getquizticket";
    private String bfo = "https://quanmin.baidu.com/pubshow/subject/answer";
    private volatile int bfr = -1;
    private final Object mLock = new Object();
    private HttpMessageListener bft = new HttpMessageListener(1021215) { // from class: com.baidu.live.guess.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuessVoucherHttpResponseMessage)) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (c.this.bfp != null) {
                        c.this.bfp.onFailure(httpResponsedMessage.getError());
                        return;
                    }
                    return;
                }
                GuessVoucherHttpResponseMessage guessVoucherHttpResponseMessage = (GuessVoucherHttpResponseMessage) httpResponsedMessage;
                if (c.this.bfp != null) {
                    c.this.bfp.d(guessVoucherHttpResponseMessage.getVoucherNum(), guessVoucherHttpResponseMessage.getTaskUrl(), guessVoucherHttpResponseMessage.isFollow());
                }
            }
        }
    };
    private HttpMessageListener bfu = new HttpMessageListener(1021218) { // from class: com.baidu.live.guess.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessUploadAnswerResponseMessage guessUploadAnswerResponseMessage = (GuessUploadAnswerResponseMessage) httpResponsedMessage;
            if (guessUploadAnswerResponseMessage.getStatusCode() != 200 || c.this.getErrorCode() != 0) {
                c.this.bfq.onFailure(httpResponsedMessage.getStatusCode(), httpResponsedMessage.getErrorString());
            } else if (c.this.bfq != null) {
                if (guessUploadAnswerResponseMessage.getStatus() == 0) {
                    c.this.bfq.Kn();
                } else {
                    c.this.bfq.onFailure(guessUploadAnswerResponseMessage.getStatus(), guessUploadAnswerResponseMessage.getMsg());
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Kn();

        void onFailure(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void d(int i, String str, boolean z);

        void onFailure(int i);
    }

    /* renamed from: com.baidu.live.guess.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0184c {
        void a(AlaGuessQuesData alaGuessQuesData);

        void b(AlaGuessQuesData alaGuessQuesData);
    }

    public c(InterfaceC0184c interfaceC0184c) {
        this.bfm = interfaceC0184c;
    }

    public void Kj() {
        if (this.bfj == null) {
            this.bfj = new CustomMessageListener(2913251) { // from class: com.baidu.live.guess.c.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        List<String> list = (List) customResponsedMessage.getData();
                        if (list.size() != 0 && c.this.Km() != -1 && c.this.Km() != 2) {
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
                                        c.this.bfm.b(c.this.bfl);
                                    } else if (TextUtils.equals(optString, "subject_mi_info")) {
                                        c.this.a(jSONObject2, parseLong);
                                        c.this.bfm.a(c.this.bfk);
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
        registerListener(this.bfj);
        registerListener(this.bft);
        registerListener(this.bfu);
        Kl();
        Kk();
    }

    private void Kk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021218, this.bfo);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessUploadAnswerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Kl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021215, this.bfn);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessVoucherHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void eE(int i) {
        this.bfr = i;
    }

    public int Km() {
        return this.bfr;
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
        if (this.bfk == null) {
            this.bfk = new AlaGuessQuesData();
        }
        this.bfk.setRoomId(j);
        this.bfk.setQuesContent(jSONObject.optString("ques_content"));
        this.bfk.setQuesId(jSONObject.optLong("ques_id"));
        this.bfk.setAnswerInfo(jSONObject.optString(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bfk.setAnswerTime(jSONObject.optInt("answer_time"));
        this.bfk.setAmount(JavaTypesHelper.toInt(jSONObject.optString(LogConfig.LOG_AMOUNT), 0));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bfk.setFirstOpt(split[0]);
        this.bfk.setSecondOpt(split[1]);
        this.bfk.setAnchorId(JavaTypesHelper.toLong(jSONObject.optString("anchor_uid"), 0L));
        this.bfk.setContentType("subject_mi_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, long j) {
        if (this.bfl == null) {
            this.bfl = new AlaGuessQuesData();
        }
        this.bfl.setRoomId(j);
        this.bfl.setAnswer(jSONObject.optInt(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bfl.setTotalNum(JavaTypesHelper.toLong(jSONObject.optString("total_number"), 0L));
        this.bfl.setCorrectNum(JavaTypesHelper.toLong(jSONObject.optString("currect_number"), 0L));
        this.bfl.setCorrectPercent(JavaTypesHelper.toDouble(jSONObject.optString("currect_percent"), 0.0d));
        this.bfl.setAmount(JavaTypesHelper.toLong(jSONObject.optString(LogConfig.LOG_AMOUNT), 0L));
        this.bfl.setAverage(JavaTypesHelper.toFloat(jSONObject.optString("average_amount"), 0.0f));
        this.bfl.setQuesContent(jSONObject.optString("ques_content"));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bfl.setFirstOpt(split[0]);
        this.bfl.setSecondOpt(split[1]);
        this.bfl.setQuesId(JavaTypesHelper.toLong(jSONObject.optString("ques_id"), 0L));
        this.bfl.setContentType(AlaGuessQuesData.ANSWER_INFO);
    }

    public void Ke() {
        this.bfr = -1;
    }

    public void onDestroy() {
        if (this.bfk != null) {
            this.bfk.reset();
        }
        if (this.bfl != null) {
            this.bfl.reset();
        }
        MessageManager.getInstance().unRegisterListener(this.bfj);
        MessageManager.getInstance().unRegisterListener(this.bft);
        MessageManager.getInstance().unRegisterTask(1021215);
    }

    public void a(long j, int i, b bVar) {
        this.bfp = bVar;
        com.baidu.live.guess.http.b bVar2 = new com.baidu.live.guess.http.b();
        bVar2.setUserId(j);
        bVar2.eF(i);
        MessageManager.getInstance().sendMessage(bVar2);
    }

    public void a(long j, long j2, int i, a aVar) {
        this.bfq = aVar;
        com.baidu.live.guess.http.a aVar2 = new com.baidu.live.guess.http.a();
        aVar2.setUserId(j);
        aVar2.setAnswer(i);
        aVar2.setQuesId(j2);
        aVar2.setCuid(TbadkCoreApplication.getInst().getCuid());
        MessageManager.getInstance().sendMessage(aVar2);
    }
}
