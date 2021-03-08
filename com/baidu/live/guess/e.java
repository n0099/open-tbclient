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
import com.baidu.live.data.n;
import com.baidu.live.data.o;
import com.baidu.live.guess.http.GuessGroupInfoHttpResponseMessage;
import com.baidu.live.guess.http.GuessResultHttpResponseMessage;
import com.baidu.live.guess.http.GuessUploadAnswerResponseMessage;
import com.baidu.live.guess.http.GuessVoucherHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends BdBaseModel {
    private CustomMessageListener bkX;
    private AlaGuessQuesData bkY;
    private AlaGuessQuesData bkZ;
    private InterfaceC0181e bla;
    private d blf;
    private a blg;
    private b bli;
    private c blj;
    private String blb = "https://quanmin.baidu.com/pubshow/task/Getquizticket";
    private String blc = "https://quanmin.baidu.com/pubshow/subject/answer";
    private String bld = "https://quanmin.baidu.com/pubshow/team/teaminfo";
    private String ble = "https://quanmin.baidu.com/pubshow/subject/getanswerresult";
    private volatile int blh = -1;
    private HttpMessageListener blk = new HttpMessageListener(1021215) { // from class: com.baidu.live.guess.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuessVoucherHttpResponseMessage)) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (e.this.blf != null) {
                        e.this.blf.onFailure(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                GuessVoucherHttpResponseMessage guessVoucherHttpResponseMessage = (GuessVoucherHttpResponseMessage) httpResponsedMessage;
                if (e.this.blf != null) {
                    e.this.blf.a(guessVoucherHttpResponseMessage.getVoucherNum(), guessVoucherHttpResponseMessage.getTaskUrl(), guessVoucherHttpResponseMessage.isFollow(), guessVoucherHttpResponseMessage.getDoubleTicketNumber());
                }
            }
        }
    };
    private HttpMessageListener bll = new HttpMessageListener(1021218) { // from class: com.baidu.live.guess.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessUploadAnswerResponseMessage guessUploadAnswerResponseMessage = (GuessUploadAnswerResponseMessage) httpResponsedMessage;
            if (guessUploadAnswerResponseMessage.getStatusCode() != 200 || e.this.getErrorCode() != 0) {
                e.this.blg.onFailure(httpResponsedMessage.getStatusCode(), httpResponsedMessage.getErrorString());
            } else if (e.this.blg != null) {
                if (guessUploadAnswerResponseMessage.getStatus() == 0) {
                    e.this.blg.Jp();
                } else {
                    e.this.blg.onFailure(guessUploadAnswerResponseMessage.getStatus(), guessUploadAnswerResponseMessage.getMsg());
                }
            }
        }
    };
    private HttpMessageListener blm = new HttpMessageListener(1021237) { // from class: com.baidu.live.guess.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessGroupInfoHttpResponseMessage guessGroupInfoHttpResponseMessage = (GuessGroupInfoHttpResponseMessage) httpResponsedMessage;
            if (guessGroupInfoHttpResponseMessage.getStatusCode() != 200 || e.this.getErrorCode() != 0) {
                if (e.this.bli != null) {
                    e.this.bli.onFailure(guessGroupInfoHttpResponseMessage.getError(), guessGroupInfoHttpResponseMessage.getErrorString());
                }
            } else if (e.this.bli != null) {
                e.this.bli.N(guessGroupInfoHttpResponseMessage.getGroupList());
            }
        }
    };
    private HttpMessageListener bln = new HttpMessageListener(1021239) { // from class: com.baidu.live.guess.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessResultHttpResponseMessage guessResultHttpResponseMessage = (GuessResultHttpResponseMessage) httpResponsedMessage;
            if (guessResultHttpResponseMessage.getStatusCode() != 200 || e.this.getErrorCode() != 0) {
                if (e.this.blj != null) {
                    e.this.blj.onFailure(guessResultHttpResponseMessage.getError(), guessResultHttpResponseMessage.getErrorString());
                }
            } else if (e.this.blj != null) {
                e.this.blj.a(guessResultHttpResponseMessage.Jq());
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void Jp();

        void onFailure(int i, String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void N(List<n> list);

        void onFailure(int i, String str);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a(o oVar);

        void onFailure(int i, String str);
    }

    /* loaded from: classes10.dex */
    public interface d {
        void a(int i, String str, boolean z, int i2);

        void onFailure(int i, String str);
    }

    /* renamed from: com.baidu.live.guess.e$e  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0181e {
        void a(AlaGuessQuesData alaGuessQuesData);

        void b(AlaGuessQuesData alaGuessQuesData);
    }

    public e(InterfaceC0181e interfaceC0181e) {
        this.bla = interfaceC0181e;
    }

    public void a(b bVar) {
        this.bli = bVar;
    }

    public void Jj() {
        if (this.bkX == null) {
            this.bkX = new CustomMessageListener(2913251) { // from class: com.baidu.live.guess.e.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        List<String> list = (List) customResponsedMessage.getData();
                        if (list.size() != 0 && e.this.Jo() != -1 && e.this.Jo() != 2) {
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
                                    if (TextUtils.equals(optString, "answer_im_info_three")) {
                                        e.this.b(jSONObject2, parseLong);
                                        e.this.bla.b(e.this.bkZ);
                                    } else if (TextUtils.equals(optString, "subject_im_info_three")) {
                                        e.this.a(jSONObject2, parseLong);
                                        e.this.bla.a(e.this.bkY);
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
        registerListener(this.bkX);
        registerListener(this.blk);
        registerListener(this.bll);
        registerListener(this.blm);
        registerListener(this.bln);
        Jn();
        Jm();
        Jl();
        Jk();
    }

    private void Jk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021239, this.ble);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuessResultHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Jl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021237, this.bld);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessGroupInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Jm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021218, this.blc);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessUploadAnswerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Jn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021215, this.blb);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessVoucherHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void dy(int i) {
        this.blh = i;
    }

    public int Jo() {
        return this.blh;
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
        if (this.bkY == null) {
            this.bkY = new AlaGuessQuesData();
        }
        this.bkY.setRoomId(j);
        this.bkY.setQuesContent(jSONObject.optString("ques_content"));
        this.bkY.setQuesId(jSONObject.optLong("ques_id"));
        this.bkY.setAnswerInfo(jSONObject.optString("answer"));
        this.bkY.setAnswerTime(jSONObject.optInt("answer_time"));
        this.bkY.setAmount(JavaTypesHelper.toInt(jSONObject.optString(LogConfig.LOG_AMOUNT), 0));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bkY.setFirstOpt(split[0]);
        this.bkY.setSecondOpt(split[1]);
        this.bkY.setAnchorId(JavaTypesHelper.toLong(jSONObject.optString("anchor_uid"), 0L));
        this.bkY.setContentType("subject_im_info_three");
        this.bkY.setDoubleTicketImg(jSONObject.optString("double_coupon_img"));
        this.bkY.setDoubleTicketTitle(jSONObject.optString("double_coupon_title"));
        this.bkY.setDoubleTicketContent(jSONObject.optString("double_coupon_content"));
        this.bkY.setDoubleTicketSwitch(jSONObject.optInt("is_double_coupon") == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, long j) {
        if (this.bkZ == null) {
            this.bkZ = new AlaGuessQuesData();
        }
        this.bkZ.setRoomId(j);
        this.bkZ.setAnswer(jSONObject.optInt("answer"));
        this.bkZ.setTotalNum(JavaTypesHelper.toLong(jSONObject.optString("total_number"), 0L));
        this.bkZ.setCorrectNum(JavaTypesHelper.toLong(jSONObject.optString("currect_number"), 0L));
        this.bkZ.setCorrectPercent(JavaTypesHelper.toDouble(jSONObject.optString("currect_percent"), 0.0d));
        this.bkZ.setAmount(JavaTypesHelper.toLong(jSONObject.optString(LogConfig.LOG_AMOUNT), 0L));
        this.bkZ.setAverage(JavaTypesHelper.toFloat(jSONObject.optString("average_amount"), 0.0f));
        this.bkZ.setDoubleAverage(JavaTypesHelper.toFloat(jSONObject.optString("double_amount"), 0.0f));
        this.bkZ.setQuesContent(jSONObject.optString("ques_content"));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bkZ.setFirstOpt(split[0]);
        this.bkZ.setSecondOpt(split[1]);
        this.bkZ.setQuesId(JavaTypesHelper.toLong(jSONObject.optString("ques_id"), 0L));
        this.bkZ.setContentType("answer_im_info_three");
    }

    public void Jc() {
        this.blh = -1;
    }

    public void onDestroy() {
        if (this.bkY != null) {
            this.bkY.reset();
        }
        if (this.bkZ != null) {
            this.bkZ.reset();
        }
        MessageManager.getInstance().unRegisterListener(this.blm);
        MessageManager.getInstance().unRegisterListener(this.bkX);
        MessageManager.getInstance().unRegisterListener(this.blk);
        MessageManager.getInstance().unRegisterTask(1021215);
        MessageManager.getInstance().unRegisterListener(this.bln);
    }

    public void a(long j, int i, d dVar) {
        this.blf = dVar;
        com.baidu.live.guess.http.d dVar2 = new com.baidu.live.guess.http.d();
        dVar2.setUserId(ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        dVar2.dz(i);
        MessageManager.getInstance().sendMessage(dVar2);
    }

    public void a(long j, long j2, int i, int i2, a aVar) {
        this.blg = aVar;
        com.baidu.live.guess.http.c cVar = new com.baidu.live.guess.http.c();
        cVar.setUserId(ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        cVar.setAnswer(i);
        cVar.setQuesId(j2);
        cVar.aV(i2);
        cVar.setCuid(TbadkCoreApplication.getInst().getCuid());
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void c(String str, long j, int i) {
        com.baidu.live.guess.http.a aVar = new com.baidu.live.guess.http.a();
        aVar.setUserId(str);
        aVar.setQuesId(j);
        aVar.setIsFirst(i);
        MessageManager.getInstance().sendMessage(aVar);
    }

    public void a(long j, String str, String str2, long j2, c cVar) {
        this.blj = cVar;
        com.baidu.live.guess.http.b bVar = new com.baidu.live.guess.http.b();
        bVar.setUserId(str);
        bVar.setQuesId(j);
        bVar.fz(str2);
        bVar.setRoomId(j2);
        MessageManager.getInstance().sendMessage(bVar);
    }
}
