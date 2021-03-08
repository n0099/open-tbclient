package com.baidu.live.yuyinim.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ab;
import com.baidu.live.data.bq;
import com.baidu.live.data.dj;
import com.baidu.live.im.g;
import com.baidu.live.message.ShowRoomCard;
import com.baidu.live.message.YuyinShowRoomDialogMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.b;
import com.baidu.tbadk.TbConfig;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.b, com.baidu.live.yuyinim.a> {
    protected static int bpd = 1;
    private String aFb;
    protected boolean bpf;
    protected boolean bph;
    private boolean bpi;
    private long bpj;
    private int bpk;
    private int bpl;
    private boolean bpm;
    protected com.baidu.live.yuyinim.b.b cer;
    private Set<Integer> ces;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void KC();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bph = false;
        this.bpi = false;
        this.bpj = 0L;
        this.ces = new HashSet();
        this.cer = new com.baidu.live.yuyinim.b.b();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: z */
    public com.baidu.live.yuyinim.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.yuyinim.a(this.mContext, 2 == bpd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(35:1|(2:3|(23:5|6|7|8|(1:10)(2:149|150)|11|12|13|(1:17)|18|(1:147)(2:22|(1:24)(2:123|(1:125)(2:126|(1:128)(2:129|(1:131)(2:132|(5:135|136|138|139|140))))))|25|(2:27|(1:68)(2:33|(1:67)))|(1:(1:122)(2:114|(2:117|118)))(1:74)|75|(5:102|(1:106)|107|(1:109)|110)(1:79)|80|(1:82)|83|(1:85)(1:101)|86|(1:100)(2:94|(1:96)(1:99))|97))|153|6|7|8|(0)(0)|11|12|13|(2:15|17)|18|(1:20)|147|25|(0)|(1:70)|(1:112)|122|75|(1:77)|102|(1:106)|107|(0)|110|80|(0)|83|(0)(0)|86|(1:88)|100|97|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0217, code lost:
        r3 = "";
        r9 = r6;
        r10 = r7;
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b A[Catch: JSONException -> 0x0216, TryCatch #3 {JSONException -> 0x0216, blocks: (B:8:0x0043, B:10:0x004b, B:11:0x0052, B:61:0x020a), top: B:153:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x020a A[Catch: JSONException -> 0x0216, TRY_ENTER, TRY_LEAVE, TryCatch #3 {JSONException -> 0x0216, blocks: (B:8:0x0043, B:10:0x004b, B:11:0x0052, B:61:0x020a), top: B:153:0x0043 }] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar) {
        int i2;
        String str;
        String str2;
        boolean z;
        SpannableStringBuilder a2;
        SpannableStringBuilder d;
        SpannableStringBuilder spannableStringBuilder;
        Exception e;
        String str3;
        String optString;
        this.bpi = false;
        KC();
        aVar.reset();
        if (bVar.Lc() != null) {
            List<AlaLiveMarkData> list = bVar.Lc().aHz;
            if (!ListUtils.isEmpty(list)) {
                i2 = V(list);
                boolean a3 = a(bVar, aVar, i2);
                boolean a4 = a(bVar, i2);
                JSONObject jSONObject = null;
                String str4 = "";
                String str5 = "";
                String str6 = null;
                String str7 = null;
                if (!(bVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                String optString2 = jSONObject.optString("content_type");
                str4 = jSONObject.optString("text");
                str5 = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
                str = jSONObject.optString("level_id");
                String str8 = str5;
                String str9 = str4;
                str2 = optString2;
                if (!TextUtils.isEmpty(str) && JavaTypesHelper.toInt(str, 0) > 0) {
                    bVar.Lc().level_id = JavaTypesHelper.toInt(str, 0);
                }
                this.cer.brq = false;
                this.cer.brr = false;
                this.cer.brs = false;
                this.cer.brt = false;
                this.cer.bru = false;
                if (!"send_redpacket".equals(str2) || "start_grab_redpacket".equals(str2)) {
                    this.cer.brq = true;
                } else if ("guard_seat".equals(str2)) {
                    this.cer.brr = true;
                } else if ("guard_club_join".equals(str2)) {
                    this.cer.brs = true;
                } else if ("haokan_buy_goods".equals(str2)) {
                    this.cer.brt = true;
                } else if ("privilege_award_royal_success".equals(str2)) {
                    this.cer.bru = true;
                } else if ("audio_emoticon".equals(str2) && jSONObject != null) {
                    try {
                        jSONObject.optJSONObject("emoticon_info").optString("compression_img");
                        optString = jSONObject.optJSONObject("emoticon_info").optString("prototype_img");
                    } catch (Exception e2) {
                        e = e2;
                        str3 = null;
                    }
                    try {
                        str7 = jSONObject.optJSONObject("emoticon_info").optString("result_img");
                        str6 = optString;
                    } catch (Exception e3) {
                        e = e3;
                        str3 = optString;
                        e.printStackTrace();
                        str6 = str3;
                        this.bpm = a4;
                        aVar.blR = a3;
                        z = false;
                        if (!bVar.Ln()) {
                        }
                        if (!z) {
                        }
                        if (!z) {
                        }
                        aVar.a(false, "", 0);
                        aVar.blO.setOnClickListener(null);
                        if (!(bVar instanceof com.baidu.live.im.a)) {
                        }
                        a2 = a(bVar, aVar);
                        d = d(bVar.Lc());
                        if (this.bpi) {
                        }
                        if (bVar instanceof com.baidu.live.im.a) {
                        }
                        spannableStringBuilder = a2;
                        aVar.a(this.mContext, this.cer);
                        aVar.n(this.mContext, this.cer.brp);
                        aVar.blL.setHighlightColor(this.mContext.getResources().getColor(17170445));
                        aVar.blL.setMovementMethod(com.baidu.live.im.g.Kd());
                        if (this.bph) {
                        }
                        if (TextUtils.equals(str2, "play_rules")) {
                        }
                        if (!"audio_emoticon".equals(str2)) {
                        }
                        aVar.cek.setVisibility(8);
                        return view;
                    }
                }
                this.bpm = a4;
                aVar.blR = a3;
                z = false;
                if (!bVar.Ln()) {
                    if (bVar.getMsgType() == 24 || bVar.getMsgType() == 1 || bVar.getMsgType() == 126) {
                        z = true;
                    } else if ((bVar.getMsgType() == 13 || bVar.getMsgType() == 27) && (TextUtils.equals(str2, "follow_anchor") || TextUtils.equals(str2, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str2, "share_tieba") || TextUtils.equals(str2, "play_rules") || TextUtils.equals(str2, "enter_live") || TextUtils.equals(str2, "share_rmb") || TextUtils.equals(str2, "zan_rmb") || TextUtils.equals(str2, "audio_emoticon") || TextUtils.equals(str2, "follow_anchor_phone") || TextUtils.equals(str2, "audio_hat_level_toast") || TextUtils.equals(str2, "audio_hat_user_toast") || TextUtils.equals(str2, "follow_room") || TextUtils.equals(str2, "audio_link_toast") || TextUtils.equals(str2, "mode_change_stage") || TextUtils.equals(str2, "mode_add_time"))) {
                        z = true;
                    }
                }
                if (!z && bVar.Lc() != null && !TextUtils.isEmpty(bVar.Lc().portrait)) {
                    aVar.a(true, bVar.Lc().portrait, i2);
                    aVar.blO.setOnClickListener(new c(bVar.Lc(), this.mGroupId, this.mLiveId, this.bpf, this.aFb));
                } else if (!z && TextUtils.equals(str2, "play_rules")) {
                    if (TextUtils.equals(str2, "play_rules") && jSONObject != null) {
                        try {
                            final String optString3 = jSONObject.optString("room_id");
                            final String optString4 = jSONObject.optString("live_id");
                            aVar.a(true, jSONObject.optString("cover"), i2);
                            aVar.blO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.a.b.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    b.this.aX(optString4, optString3);
                                }
                            });
                            aVar.cej.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.a.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    b.this.aX(optString4, optString3);
                                }
                            });
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } else {
                    aVar.a(false, "", 0);
                    aVar.blO.setOnClickListener(null);
                }
                if (!(bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).blA != null) {
                    spannableStringBuilder = ((com.baidu.live.im.a) bVar).blA;
                } else {
                    a2 = a(bVar, aVar);
                    d = d(bVar.Lc());
                    if (this.bpi && d != null && a2 != null) {
                        a2.insert(0, (CharSequence) d);
                    }
                    if (bVar instanceof com.baidu.live.im.a) {
                        ((com.baidu.live.im.a) bVar).blA = a2;
                    }
                    spannableStringBuilder = a2;
                }
                aVar.a(this.mContext, this.cer);
                aVar.n(this.mContext, this.cer.brp);
                aVar.blL.setHighlightColor(this.mContext.getResources().getColor(17170445));
                aVar.blL.setMovementMethod(com.baidu.live.im.g.Kd());
                if (this.bph) {
                    aVar.ci(true);
                }
                if (TextUtils.equals(str2, "play_rules")) {
                    aVar.cej.setText(str8 + "：");
                    aVar.cej.setVisibility(0);
                    aVar.blL.setText(str9);
                    aVar.blL.setTextColor(Color.parseColor("#9BAEFD"));
                } else {
                    aVar.cej.setVisibility(8);
                    aVar.blL.setText(spannableStringBuilder);
                }
                if (!"audio_emoticon".equals(str2) && !StringUtils.isNull(str6, true) && bVar.getMsgType() == 13 && !StringUtils.isNull(str7, true)) {
                    aVar.cek.setVisibility(0);
                    if (this.ces.contains(Integer.valueOf(i))) {
                        aVar.cek.aK(null, str7);
                    } else {
                        this.ces.add(Integer.valueOf(i));
                        aVar.cek.aK(str6, str7);
                    }
                } else {
                    aVar.cek.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        boolean a32 = a(bVar, aVar, i2);
        boolean a42 = a(bVar, i2);
        JSONObject jSONObject2 = null;
        String str42 = "";
        String str52 = "";
        String str62 = null;
        String str72 = null;
        if (!(bVar.getObjContent() instanceof JSONObject)) {
        }
        String optString22 = jSONObject2.optString("content_type");
        str42 = jSONObject2.optString("text");
        str52 = jSONObject2.optString(DpStatConstants.KEY_ROOM_NAME);
        str = jSONObject2.optString("level_id");
        String str82 = str52;
        String str92 = str42;
        str2 = optString22;
        if (!TextUtils.isEmpty(str)) {
            bVar.Lc().level_id = JavaTypesHelper.toInt(str, 0);
        }
        this.cer.brq = false;
        this.cer.brr = false;
        this.cer.brs = false;
        this.cer.brt = false;
        this.cer.bru = false;
        if (!"send_redpacket".equals(str2)) {
        }
        this.cer.brq = true;
        this.bpm = a42;
        aVar.blR = a32;
        z = false;
        if (!bVar.Ln()) {
        }
        if (!z) {
        }
        if (!z) {
        }
        aVar.a(false, "", 0);
        aVar.blO.setOnClickListener(null);
        if (!(bVar instanceof com.baidu.live.im.a)) {
        }
        a2 = a(bVar, aVar);
        d = d(bVar.Lc());
        if (this.bpi) {
            a2.insert(0, (CharSequence) d);
        }
        if (bVar instanceof com.baidu.live.im.a) {
        }
        spannableStringBuilder = a2;
        aVar.a(this.mContext, this.cer);
        aVar.n(this.mContext, this.cer.brp);
        aVar.blL.setHighlightColor(this.mContext.getResources().getColor(17170445));
        aVar.blL.setMovementMethod(com.baidu.live.im.g.Kd());
        if (this.bph) {
        }
        if (TextUtils.equals(str2, "play_rules")) {
        }
        if (!"audio_emoticon".equals(str2)) {
        }
        aVar.cek.setVisibility(8);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(String str, String str2) {
        ab abVar = new ab();
        abVar.aKu = new dj();
        abVar.aKu.live_id = str;
        abVar.aKu.aVk = str2;
        MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar)));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar, int i) {
        JSONObject jSONObject;
        boolean z;
        bq bqVar;
        JSONObject jSONObject2 = null;
        String[] Lj = bVar.Lj();
        if ((bVar.getMsgType() == 1 || bVar.getMsgType() == 126) && (Lj == null || Lj.length == 0 || !TextUtils.equals(Lj[0], "guard_seat_effect")) && i >= 5) {
            try {
                jSONObject = new JSONObject();
                try {
                    if (i == 7) {
                        jSONObject.put("start_color", "#4e030c");
                        jSONObject.put("end_color", "#4e030c");
                    } else {
                        jSONObject.put("start_color", "#031f33");
                        jSONObject.put("end_color", "#031f33");
                    }
                    jSONObject.put("transparency", 60);
                    jSONObject.put("frame_start_color", "#faca21");
                    jSONObject.put("frame_end_color", "#faca21");
                    jSONObject2 = jSONObject;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = null;
            }
        } else if (com.baidu.live.ae.a.Qm().bCs != null && (bqVar = com.baidu.live.ae.a.Qm().bCs.aRo) != null && bqVar.aQV != null && Lj != null && Lj.length > 0 && !TextUtils.isEmpty(Lj[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(Lj[0], "guard_seat_effect"))) {
            jSONObject2 = bqVar.aQV.optJSONObject(Lj[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                aVar.aPZ = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                aVar.aPZ = 255;
            }
            aVar.blS = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    aVar.aPV = Color.parseColor(optString);
                    aVar.aPW = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        aVar.aPV = Color.parseColor(optString3);
                        aVar.aPW = aVar.aPV;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        aVar.aPX = Color.parseColor(optString4);
                        aVar.aPY = Color.parseColor(optString5);
                    }
                }
                return z;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.b bVar, int i) {
        JSONObject jSONObject;
        String optString;
        bq bqVar;
        int i2 = 255;
        String[] Lj = bVar.Lj();
        JSONObject jSONObject2 = null;
        if ((bVar.getMsgType() == 1 || bVar.getMsgType() == 126) && i >= 2) {
            try {
                jSONObject = new JSONObject();
                try {
                    if (i == 7) {
                        jSONObject.put("bg_color", "#ffef76");
                    } else {
                        jSONObject.put("bg_color", "#43c0a0");
                    }
                    jSONObject.put("transparency", 100);
                    jSONObject2 = jSONObject;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                    }
                    return false;
                }
            } catch (JSONException e2) {
                e = e2;
                jSONObject = null;
            }
        } else if (com.baidu.live.ae.a.Qm().bCs != null && (bqVar = com.baidu.live.ae.a.Qm().bCs.aRo) != null && bqVar.aQW != null && Lj != null && Lj.length > 1 && !TextUtils.isEmpty(Lj[1])) {
            jSONObject2 = bqVar.aQW.optJSONObject(Lj[1]);
        }
        if (jSONObject2 != null) {
            String optString2 = jSONObject2.optString("bg_color");
            if (!TextUtils.isEmpty(jSONObject2.optString("transparency"))) {
                try {
                    i2 = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                } catch (Exception e3) {
                }
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.bpk = Color.parseColor(optString2);
                this.bpl = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        bpd = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, String str) {
        this.bpi = true;
        a(spannableStringBuilder, aVar, aVar2, false, false, true, null, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2) {
        this.bpi = true;
        a(spannableStringBuilder, aVar, aVar2, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, aVar2, z, z2, z3, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3, String str, String str2) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bpi = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar3 = new a(aVar, this.mGroupId, this.mLiveId, this.bpf, this.aFb);
                aVar3.bpm = this.bpm;
                aVar3.bpk = this.bpk;
                aVar3.bpl = this.bpl;
                spannableString.setSpan(aVar3, 0, length, 17);
            } else {
                C0246b c0246b = new C0246b(aVar, this.mGroupId, this.mLiveId, this.bpf, this.aFb);
                c0246b.bpm = this.bpm;
                c0246b.bpk = this.bpk;
                c0246b.bpl = this.bpl;
                spannableString.setSpan(c0246b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            if (!TextUtils.isEmpty(str2)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str2;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinim.a.b.3
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        b.this.KA();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        int i = 0;
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aHz;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> w = w(list);
        if (ListUtils.isEmpty(w)) {
            return null;
        }
        int length = "[img] ".length();
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < w.size(); i2++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        while (true) {
            int i3 = i;
            if (i3 >= w.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = w.get(i3);
            if (alaLiveMarkData != null) {
                alaLiveMarkData.userLevel = aVar.level_id;
                alaLiveMarkData.setupNewLevelMark();
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bUv.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bph, new b.a() { // from class: com.baidu.live.yuyinim.a.b.4
                        @Override // com.baidu.live.view.b.a
                        public void e(Bitmap bitmap) {
                            b.this.KA();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bUv.put(genCacheKey, bVar);
                }
                spannableStringBuilder.setSpan(bVar, i4, i5, 17);
            }
            i = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> w(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aFb)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int V(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return 0;
        }
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                return alaLiveMarkData.royalLevel;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KA() {
        long currentTimeMillis = System.currentTimeMillis() - this.bpj;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bpj = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.a.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bpj = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bpf = z;
        this.aFb = str3;
    }

    public boolean KB() {
        return this.bpf;
    }

    /* renamed from: com.baidu.live.yuyinim.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0246b extends ClickableSpan implements g.a {
        private boolean aLc;
        private String bez;
        private int bpk;
        private int bpl;
        private boolean bpm;
        private com.baidu.live.data.a bpo;
        private String groupId;
        private String liveId;

        C0246b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpo = null;
            this.bpo = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLc = z;
            this.bez = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bpd) {
                if (this.bpm) {
                    textPaint.setColor(this.bpk);
                    textPaint.setAlpha(this.bpl);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bpd) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bpo instanceof com.baidu.live.data.a) {
                str = this.bpo.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bpo.userId, this.bpo.userName, this.bpo.portrait, this.bpo.sex, this.bpo.level_id, null, null, 0L, this.bpo.aHt, this.bpo.aHu, this.bpo.aHv, this.groupId, this.liveId, this.aLc, this.bez, str, this.bpo.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Ke() {
            if (this.bpo != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bpo.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bpo));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aLc;
        private String bez;
        private int bpk;
        private int bpl;
        private boolean bpm;
        private com.baidu.live.data.a bpo;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpo = null;
            this.bpo = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLc = z;
            this.bez = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bpd) {
                if (this.bpm) {
                    textPaint.setColor(this.bpk);
                    textPaint.setAlpha(this.bpl);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bpd) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bpo instanceof com.baidu.live.data.a) {
                str = this.bpo.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bpo.userId, this.bpo.userName, this.bpo.portrait, this.bpo.sex, this.bpo.level_id, null, null, 0L, this.bpo.aHt, this.bpo.aHu, this.bpo.aHv, this.groupId, this.liveId, this.aLc, this.bez, str, this.bpo.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Ke() {
            if (this.bpo != null) {
                if (this.bpo.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bpo));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c implements View.OnClickListener {
        private boolean aLc;
        private String bez;
        private com.baidu.live.data.a bpo;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpo = null;
            this.bpo = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLc = z;
            this.bez = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bpo.userId, this.bpo.userName, this.bpo.portrait, this.bpo.sex, this.bpo.level_id, null, null, 0L, this.bpo.aHt, this.bpo.aHu, this.bpo.aHv, this.groupId, this.liveId, this.aLc, this.bez, this.bpo.appId, this.bpo.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KD() {
        return 2 != bpd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KE() {
        this.cer.bro = true;
        this.cer.brp = false;
        this.cer.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KF() {
        this.cer.bro = false;
        this.cer.brp = false;
        this.cer.isNormal = false;
    }

    public void cm(boolean z) {
        this.bph = z;
    }

    public void cn(boolean z) {
        this.bpi = z;
    }
}
