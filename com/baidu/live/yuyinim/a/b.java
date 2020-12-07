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
import com.baidu.live.data.bj;
import com.baidu.live.im.g;
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
/* loaded from: classes4.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.b, com.baidu.live.yuyinim.a> {
    protected static int bnq = 1;
    private String aGk;
    protected com.baidu.live.yuyinim.c.a bXc;
    private Set<Integer> bXd;
    protected boolean bns;
    protected boolean bnu;
    private boolean bnv;
    private long bnw;
    private int bnx;
    private int bny;
    private boolean bnz;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void Nx();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bnu = false;
        this.bnv = false;
        this.bnw = 0L;
        this.bXd = new HashSet();
        this.bXc = new com.baidu.live.yuyinim.c.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: x */
    public com.baidu.live.yuyinim.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.yuyinim.a(this.mContext, 2 == bnq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(34:1|(2:3|(22:5|6|7|8|(2:10|11)(2:130|131)|12|13|14|15|(1:19)|20|(1:125)(2:24|(1:26)(2:100|(1:102)(2:103|(1:105)(2:106|(1:108)(2:109|(1:124)(5:112|113|115|116|117))))))|27|(1:99)(2:33|(1:98))|(1:77)(1:42)|43|(5:68|(1:72)|73|(1:75)|76)(1:47)|48|(1:50)|51|(1:67)(2:59|(2:61|(1:63))(1:66))|64))|134|6|7|8|(0)(0)|12|13|14|15|(2:17|19)|20|(1:22)|125|27|(1:29)|99|(1:38)|77|43|(1:45)|68|(1:72)|73|(0)|76|48|(0)|51|(1:53)|67|64|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x030d, code lost:
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a6, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a7, code lost:
        r8 = null;
        r2 = "";
        r4 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003d A[Catch: JSONException -> 0x01a5, TRY_LEAVE, TryCatch #1 {JSONException -> 0x01a5, blocks: (B:8:0x0035, B:10:0x003d, B:59:0x0199), top: B:130:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0199 A[Catch: JSONException -> 0x01a5, TRY_ENTER, TRY_LEAVE, TryCatch #1 {JSONException -> 0x01a5, blocks: (B:8:0x0035, B:10:0x003d, B:59:0x0199), top: B:130:0x0035 }] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        SpannableStringBuilder a2;
        SpannableStringBuilder d;
        SpannableStringBuilder spannableStringBuilder;
        Exception exc;
        String str5;
        String optString;
        JSONObject jSONObject;
        this.bnv = false;
        Nx();
        aVar.reset();
        if (bVar.NU() != null) {
            List<AlaLiveMarkData> list = bVar.NU().aID;
            if (!ListUtils.isEmpty(list)) {
                i2 = U(list);
                boolean a3 = a(bVar, aVar, i2);
                boolean a4 = a(bVar, i2);
                if (!(bVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                String optString2 = jSONObject.optString("content_type");
                str2 = jSONObject.optString("level_id");
                str = optString2;
                JSONObject jSONObject2 = jSONObject;
                if (!TextUtils.isEmpty(str2) && JavaTypesHelper.toInt(str2, 0) > 0) {
                    bVar.NU().level_id = JavaTypesHelper.toInt(str2, 0);
                }
                this.bXc.bpu = false;
                this.bXc.bpv = false;
                this.bXc.bpw = false;
                this.bXc.bpx = false;
                this.bXc.bpy = false;
                if (!"send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
                    this.bXc.bpu = true;
                    str3 = null;
                    str4 = null;
                } else if ("guard_seat".equals(str)) {
                    this.bXc.bpv = true;
                    str3 = null;
                    str4 = null;
                } else if ("guard_club_join".equals(str)) {
                    this.bXc.bpw = true;
                    str3 = null;
                    str4 = null;
                } else if ("haokan_buy_goods".equals(str)) {
                    this.bXc.bpx = true;
                    str3 = null;
                    str4 = null;
                } else if ("privilege_award_royal_success".equals(str)) {
                    this.bXc.bpy = true;
                    str3 = null;
                    str4 = null;
                } else if (!"audio_emoticon".equals(str) || jSONObject2 == null) {
                    str3 = null;
                    str4 = null;
                } else {
                    try {
                        jSONObject2.optJSONObject("emoticon_info").optString("compression_img");
                        optString = jSONObject2.optJSONObject("emoticon_info").optString("prototype_img");
                    } catch (Exception e) {
                        exc = e;
                        str5 = null;
                    }
                    try {
                        str4 = jSONObject2.optJSONObject("emoticon_info").optString("result_img");
                        str3 = optString;
                    } catch (Exception e2) {
                        exc = e2;
                        str5 = optString;
                        exc.printStackTrace();
                        str4 = null;
                        str3 = str5;
                        this.bnz = a4;
                        aVar.bkl = a3;
                        z = false;
                        if (bVar.getMsgType() != 24) {
                        }
                        z = true;
                        if (!z) {
                        }
                        aVar.a(false, "", 0);
                        aVar.bki.setOnClickListener(null);
                        if (!(bVar instanceof com.baidu.live.im.a)) {
                        }
                        a2 = a(bVar, aVar);
                        d = d(bVar.NU());
                        if (this.bnv) {
                        }
                        if (bVar instanceof com.baidu.live.im.a) {
                        }
                        spannableStringBuilder = a2;
                        aVar.a(this.mContext, this.bXc);
                        aVar.m(this.mContext, this.bXc.bpt);
                        aVar.bkf.setHighlightColor(this.mContext.getResources().getColor(17170445));
                        aVar.bkf.setMovementMethod(com.baidu.live.im.g.Na());
                        if (this.bnu) {
                        }
                        aVar.bkf.setText(spannableStringBuilder);
                        if (!"audio_emoticon".equals(str)) {
                        }
                        aVar.bWV.setVisibility(8);
                        return view;
                    }
                }
                this.bnz = a4;
                aVar.bkl = a3;
                z = false;
                if (bVar.getMsgType() != 24 || bVar.getMsgType() == 1 || bVar.getMsgType() == 126) {
                    z = true;
                } else if ((bVar.getMsgType() == 13 || bVar.getMsgType() == 27) && (TextUtils.equals(str, "follow_anchor") || TextUtils.equals(str, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str, "share_tieba") || TextUtils.equals(str, "share_rmb") || TextUtils.equals(str, "zan_rmb") || TextUtils.equals(str, "audio_emoticon") || TextUtils.equals(str, "follow_anchor_phone") || TextUtils.equals(str, "audio_hat_level_toast") || TextUtils.equals(str, "audio_hat_user_toast") || TextUtils.equals(str, "follow_room"))) {
                    z = true;
                }
                if (!z && bVar.NU() != null && !TextUtils.isEmpty(bVar.NU().portrait)) {
                    aVar.a(true, bVar.NU().portrait, i2);
                    aVar.bki.setOnClickListener(new c(bVar.NU(), this.mGroupId, this.mLiveId, this.bns, this.aGk));
                } else {
                    aVar.a(false, "", 0);
                    aVar.bki.setOnClickListener(null);
                }
                if (!(bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).bjU != null) {
                    spannableStringBuilder = ((com.baidu.live.im.a) bVar).bjU;
                } else {
                    a2 = a(bVar, aVar);
                    d = d(bVar.NU());
                    if (this.bnv && d != null && a2 != null) {
                        a2.insert(0, (CharSequence) d);
                    }
                    if (bVar instanceof com.baidu.live.im.a) {
                        ((com.baidu.live.im.a) bVar).bjU = a2;
                    }
                    spannableStringBuilder = a2;
                }
                aVar.a(this.mContext, this.bXc);
                aVar.m(this.mContext, this.bXc.bpt);
                aVar.bkf.setHighlightColor(this.mContext.getResources().getColor(17170445));
                aVar.bkf.setMovementMethod(com.baidu.live.im.g.Na());
                if (this.bnu) {
                    aVar.ce(true);
                }
                aVar.bkf.setText(spannableStringBuilder);
                if (!"audio_emoticon".equals(str) && !StringUtils.isNull(str3, true) && bVar.getMsgType() == 13 && !StringUtils.isNull(str4, true)) {
                    aVar.bWV.setVisibility(0);
                    if (this.bXd.contains(Integer.valueOf(i))) {
                        if (TextUtils.isEmpty((String) aVar.bWV.getTag())) {
                            aVar.bWV.aQ(null, str4);
                        }
                    } else {
                        this.bXd.add(Integer.valueOf(i));
                        aVar.bWV.aQ(str3, str4);
                        aVar.bWV.setTag(str4);
                    }
                } else {
                    aVar.bWV.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        boolean a32 = a(bVar, aVar, i2);
        boolean a42 = a(bVar, i2);
        if (!(bVar.getObjContent() instanceof JSONObject)) {
        }
        String optString22 = jSONObject.optString("content_type");
        str2 = jSONObject.optString("level_id");
        str = optString22;
        JSONObject jSONObject22 = jSONObject;
        if (!TextUtils.isEmpty(str2)) {
            bVar.NU().level_id = JavaTypesHelper.toInt(str2, 0);
        }
        this.bXc.bpu = false;
        this.bXc.bpv = false;
        this.bXc.bpw = false;
        this.bXc.bpx = false;
        this.bXc.bpy = false;
        if (!"send_redpacket".equals(str)) {
        }
        this.bXc.bpu = true;
        str3 = null;
        str4 = null;
        this.bnz = a42;
        aVar.bkl = a32;
        z = false;
        if (bVar.getMsgType() != 24) {
        }
        z = true;
        if (!z) {
        }
        aVar.a(false, "", 0);
        aVar.bki.setOnClickListener(null);
        if (!(bVar instanceof com.baidu.live.im.a)) {
        }
        a2 = a(bVar, aVar);
        d = d(bVar.NU());
        if (this.bnv) {
            a2.insert(0, (CharSequence) d);
        }
        if (bVar instanceof com.baidu.live.im.a) {
        }
        spannableStringBuilder = a2;
        aVar.a(this.mContext, this.bXc);
        aVar.m(this.mContext, this.bXc.bpt);
        aVar.bkf.setHighlightColor(this.mContext.getResources().getColor(17170445));
        aVar.bkf.setMovementMethod(com.baidu.live.im.g.Na());
        if (this.bnu) {
        }
        aVar.bkf.setText(spannableStringBuilder);
        if (!"audio_emoticon".equals(str)) {
        }
        aVar.bWV.setVisibility(8);
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar, int i) {
        JSONObject jSONObject;
        boolean z;
        bj bjVar;
        JSONObject jSONObject2 = null;
        String[] Ob = bVar.Ob();
        if ((bVar.getMsgType() == 1 || bVar.getMsgType() == 126) && (Ob == null || Ob.length == 0 || !TextUtils.equals(Ob[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.ae.a.RB().bxq != null && (bjVar = com.baidu.live.ae.a.RB().bxq.aQO) != null && bjVar.aQv != null && Ob != null && Ob.length > 0 && !TextUtils.isEmpty(Ob[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(Ob[0], "guard_seat_effect"))) {
            jSONObject2 = bjVar.aQv.optJSONObject(Ob[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                aVar.aPA = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                aVar.aPA = 255;
            }
            aVar.bkm = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    aVar.aPw = Color.parseColor(optString);
                    aVar.aPx = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        aVar.aPw = Color.parseColor(optString3);
                        aVar.aPx = aVar.aPw;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        aVar.aPy = Color.parseColor(optString4);
                        aVar.aPz = Color.parseColor(optString5);
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
        bj bjVar;
        int i2 = 255;
        String[] Ob = bVar.Ob();
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
        } else if (com.baidu.live.ae.a.RB().bxq != null && (bjVar = com.baidu.live.ae.a.RB().bxq.aQO) != null && bjVar.aQw != null && Ob != null && Ob.length > 1 && !TextUtils.isEmpty(Ob[1])) {
            jSONObject2 = bjVar.aQw.optJSONObject(Ob[1]);
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
                this.bnx = Color.parseColor(optString2);
                this.bny = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        bnq = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, String str) {
        this.bnv = true;
        a(spannableStringBuilder, aVar, aVar2, false, false, true, null, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2) {
        this.bnv = true;
        a(spannableStringBuilder, aVar, aVar2, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, aVar2, z, z2, z3, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3, String str, String str2) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bnv = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar3 = new a(aVar, this.mGroupId, this.mLiveId, this.bns, this.aGk);
                aVar3.bnz = this.bnz;
                aVar3.bnx = this.bnx;
                aVar3.bny = this.bny;
                spannableString.setSpan(aVar3, 0, length, 17);
            } else {
                C0247b c0247b = new C0247b(aVar, this.mGroupId, this.mLiveId, this.bns, this.aGk);
                c0247b.bnz = this.bnz;
                c0247b.bnx = this.bnx;
                c0247b.bny = this.bny;
                spannableString.setSpan(c0247b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            if (!TextUtils.isEmpty(str2)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str2;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinim.a.b.1
                    @Override // com.baidu.live.view.b.a
                    public void d(Bitmap bitmap) {
                        b.this.Nv();
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
        List<AlaLiveMarkData> list = aVar.aID;
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
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bON.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bnu, new b.a() { // from class: com.baidu.live.yuyinim.a.b.2
                        @Override // com.baidu.live.view.b.a
                        public void d(Bitmap bitmap) {
                            b.this.Nv();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bON.put(genCacheKey, bVar);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aGk)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int U(List<AlaLiveMarkData> list) {
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
    public void Nv() {
        long currentTimeMillis = System.currentTimeMillis() - this.bnw;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bnw = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bnw = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bns = z;
        this.aGk = str3;
    }

    public boolean Nw() {
        return this.bns;
    }

    /* renamed from: com.baidu.live.yuyinim.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0247b extends ClickableSpan implements g.a {
        private boolean aLj;
        private String bcY;
        private com.baidu.live.data.a bnB;
        private int bnx;
        private int bny;
        private boolean bnz;
        private String groupId;
        private String liveId;

        C0247b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bnB = null;
            this.bnB = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLj = z;
            this.bcY = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bnq) {
                if (this.bnz) {
                    textPaint.setColor(this.bnx);
                    textPaint.setAlpha(this.bny);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bnq) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bnB instanceof com.baidu.live.data.a) {
                str = this.bnB.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bnB.userId, this.bnB.userName, this.bnB.portrait, this.bnB.sex, this.bnB.level_id, null, null, 0L, this.bnB.aIx, this.bnB.aIy, this.bnB.aIz, this.groupId, this.liveId, this.aLj, this.bcY, str, this.bnB.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Nb() {
            if (this.bnB != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bnB.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bnB));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aLj;
        private String bcY;
        private com.baidu.live.data.a bnB;
        private int bnx;
        private int bny;
        private boolean bnz;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bnB = null;
            this.bnB = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLj = z;
            this.bcY = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bnq) {
                if (this.bnz) {
                    textPaint.setColor(this.bnx);
                    textPaint.setAlpha(this.bny);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bnq) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bnB instanceof com.baidu.live.data.a) {
                str = this.bnB.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bnB.userId, this.bnB.userName, this.bnB.portrait, this.bnB.sex, this.bnB.level_id, null, null, 0L, this.bnB.aIx, this.bnB.aIy, this.bnB.aIz, this.groupId, this.liveId, this.aLj, this.bcY, str, this.bnB.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Nb() {
            if (this.bnB != null) {
                if (this.bnB.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bnB));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements View.OnClickListener {
        private boolean aLj;
        private String bcY;
        private com.baidu.live.data.a bnB;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bnB = null;
            this.bnB = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLj = z;
            this.bcY = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bnB.userId, this.bnB.userName, this.bnB.portrait, this.bnB.sex, this.bnB.level_id, null, null, 0L, this.bnB.aIx, this.bnB.aIy, this.bnB.aIz, this.groupId, this.liveId, this.aLj, this.bcY, this.bnB.appId, this.bnB.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ny() {
        return 2 != bnq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nz() {
        this.bXc.bps = true;
        this.bXc.bpt = false;
        this.bXc.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NA() {
        this.bXc.bps = false;
        this.bXc.bpt = false;
        this.bXc.isNormal = false;
    }

    public void ci(boolean z) {
        this.bnu = z;
    }

    public void cj(boolean z) {
        this.bnv = z;
    }
}
