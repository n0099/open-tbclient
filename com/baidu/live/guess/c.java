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
    private CustomMessageListener bjA;
    private AlaGuessQuesData bjB;
    private AlaGuessQuesData bjC;
    private InterfaceC0189c bjD;
    private b bjG;
    private a bjH;
    private String bjE = "https://quanmin.baidu.com/pubshow/task/Getquizticket";
    private String bjF = "https://quanmin.baidu.com/pubshow/subject/answer";
    private volatile int bjI = -1;
    private final Object mLock = new Object();
    private HttpMessageListener bjJ = new HttpMessageListener(1021215) { // from class: com.baidu.live.guess.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuessVoucherHttpResponseMessage)) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (c.this.bjG != null) {
                        c.this.bjG.onFailure(httpResponsedMessage.getError());
                        return;
                    }
                    return;
                }
                GuessVoucherHttpResponseMessage guessVoucherHttpResponseMessage = (GuessVoucherHttpResponseMessage) httpResponsedMessage;
                if (c.this.bjG != null) {
                    c.this.bjG.d(guessVoucherHttpResponseMessage.getVoucherNum(), guessVoucherHttpResponseMessage.getTaskUrl(), guessVoucherHttpResponseMessage.isFollow());
                }
            }
        }
    };
    private HttpMessageListener bjK = new HttpMessageListener(1021218) { // from class: com.baidu.live.guess.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessUploadAnswerResponseMessage guessUploadAnswerResponseMessage = (GuessUploadAnswerResponseMessage) httpResponsedMessage;
            if (guessUploadAnswerResponseMessage.getStatusCode() != 200 || c.this.getErrorCode() != 0) {
                c.this.bjH.onFailure(httpResponsedMessage.getStatusCode(), httpResponsedMessage.getErrorString());
            } else if (c.this.bjH != null) {
                if (guessUploadAnswerResponseMessage.getStatus() == 0) {
                    c.this.bjH.Mp();
                } else {
                    c.this.bjH.onFailure(guessUploadAnswerResponseMessage.getStatus(), guessUploadAnswerResponseMessage.getMsg());
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Mp();

        void onFailure(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void d(int i, String str, boolean z);

        void onFailure(int i);
    }

    /* renamed from: com.baidu.live.guess.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0189c {
        void a(AlaGuessQuesData alaGuessQuesData);

        void b(AlaGuessQuesData alaGuessQuesData);
    }

    public c(InterfaceC0189c interfaceC0189c) {
        this.bjD = interfaceC0189c;
    }

    public void Ml() {
        if (this.bjA == null) {
            this.bjA = new CustomMessageListener(2913251) { // from class: com.baidu.live.guess.c.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        List<String> list = (List) customResponsedMessage.getData();
                        if (list.size() != 0 && c.this.Mo() != -1 && c.this.Mo() != 2) {
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
                                        c.this.bjD.b(c.this.bjC);
                                    } else if (TextUtils.equals(optString, "subject_mi_info")) {
                                        c.this.a(jSONObject2, parseLong);
                                        c.this.bjD.a(c.this.bjB);
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
        registerListener(this.bjA);
        registerListener(this.bjJ);
        registerListener(this.bjK);
        Mn();
        Mm();
    }

    private void Mm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021218, this.bjF);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessUploadAnswerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Mn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021215, this.bjE);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessVoucherHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void fa(int i) {
        this.bjI = i;
    }

    public int Mo() {
        return this.bjI;
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
        if (this.bjB == null) {
            this.bjB = new AlaGuessQuesData();
        }
        this.bjB.setRoomId(j);
        this.bjB.setQuesContent(jSONObject.optString("ques_content"));
        this.bjB.setQuesId(jSONObject.optLong("ques_id"));
        this.bjB.setAnswerInfo(jSONObject.optString(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bjB.setAnswerTime(jSONObject.optInt("answer_time"));
        this.bjB.setAmount(JavaTypesHelper.toInt(jSONObject.optString(LogConfig.LOG_AMOUNT), 0));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bjB.setFirstOpt(split[0]);
        this.bjB.setSecondOpt(split[1]);
        this.bjB.setAnchorId(JavaTypesHelper.toLong(jSONObject.optString("anchor_uid"), 0L));
        this.bjB.setContentType("subject_mi_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, long j) {
        if (this.bjC == null) {
            this.bjC = new AlaGuessQuesData();
        }
        this.bjC.setRoomId(j);
        this.bjC.setAnswer(jSONObject.optInt(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bjC.setTotalNum(JavaTypesHelper.toLong(jSONObject.optString("total_number"), 0L));
        this.bjC.setCorrectNum(JavaTypesHelper.toLong(jSONObject.optString("currect_number"), 0L));
        this.bjC.setCorrectPercent(JavaTypesHelper.toDouble(jSONObject.optString("currect_percent"), 0.0d));
        this.bjC.setAmount(JavaTypesHelper.toLong(jSONObject.optString(LogConfig.LOG_AMOUNT), 0L));
        this.bjC.setAverage(JavaTypesHelper.toFloat(jSONObject.optString("average_amount"), 0.0f));
        this.bjC.setQuesContent(jSONObject.optString("ques_content"));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bjC.setFirstOpt(split[0]);
        this.bjC.setSecondOpt(split[1]);
        this.bjC.setQuesId(JavaTypesHelper.toLong(jSONObject.optString("ques_id"), 0L));
        this.bjC.setContentType(AlaGuessQuesData.ANSWER_INFO);
    }

    public void Mg() {
        this.bjI = -1;
    }

    public void onDestroy() {
        if (this.bjB != null) {
            this.bjB.reset();
        }
        if (this.bjC != null) {
            this.bjC.reset();
        }
        MessageManager.getInstance().unRegisterListener(this.bjA);
        MessageManager.getInstance().unRegisterListener(this.bjJ);
        MessageManager.getInstance().unRegisterTask(1021215);
    }

    public void a(long j, int i, b bVar) {
        this.bjG = bVar;
        com.baidu.live.guess.http.b bVar2 = new com.baidu.live.guess.http.b();
        bVar2.setUserId(j);
        bVar2.fb(i);
        MessageManager.getInstance().sendMessage(bVar2);
    }

    public void a(long j, long j2, int i, a aVar) {
        this.bjH = aVar;
        com.baidu.live.guess.http.a aVar2 = new com.baidu.live.guess.http.a();
        aVar2.setUserId(j);
        aVar2.setAnswer(i);
        aVar2.setQuesId(j2);
        aVar2.setCuid(TbadkCoreApplication.getInst().getCuid());
        MessageManager.getInstance().sendMessage(aVar2);
    }
}
