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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bg;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.c;
import com.baidu.tbadk.TbConfig;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.a, com.baidu.live.yuyinim.a> {
    protected static int bjp = 1;
    private String aEz;
    protected com.baidu.live.yuyinim.c.a bNN;
    private Set<Integer> bNO;
    protected boolean bjr;
    protected boolean bjs;
    private boolean bjt;
    private long bju;
    private int bjv;
    private int bjw;
    private boolean bjx;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void LB();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bjs = false;
        this.bjt = false;
        this.bju = 0L;
        this.bNO = new HashSet();
        this.bNN = new com.baidu.live.yuyinim.c.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: z */
    public com.baidu.live.yuyinim.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.yuyinim.a(this.mContext, 2 == bjp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(30:1|(2:3|(19:5|6|7|8|(1:10)(2:111|112)|11|12|13|(1:109)(2:17|(1:19)(2:84|(1:86)(2:87|(1:89)(2:90|(1:92)(2:93|(1:108)(5:96|97|98|99|100))))))|20|(1:83)(2:26|(1:82))|(1:65)(1:35)|36|(4:57|(1:61)|62|(1:64))(1:40)|41|(1:43)|44|(1:56)(2:50|(1:52)(1:55))|53))|115|6|7|8|(0)(0)|11|12|13|(1:15)|109|20|(1:22)|83|(1:31)|65|36|(1:38)|57|(1:61)|62|(0)|41|(0)|44|(1:46)|56|53|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x016c, code lost:
        r8 = null;
        r2 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003a A[Catch: JSONException -> 0x016b, TryCatch #0 {JSONException -> 0x016b, blocks: (B:8:0x0032, B:10:0x003a, B:11:0x0041, B:49:0x015f), top: B:110:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015f A[Catch: JSONException -> 0x016b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x016b, blocks: (B:8:0x0032, B:10:0x003a, B:11:0x0041, B:49:0x015f), top: B:110:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x027e A[ADDED_TO_REGION] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2) {
        int i2;
        String str;
        String str2;
        String str3;
        boolean z;
        SpannableStringBuilder a2;
        SpannableStringBuilder d;
        Exception exc;
        String str4;
        this.bjt = false;
        LB();
        aVar2.reset();
        if (aVar.LO() != null) {
            List<AlaLiveMarkData> list = aVar.LO().aGQ;
            if (!ListUtils.isEmpty(list)) {
                i2 = T(list);
                boolean a3 = a(aVar, aVar2, i2);
                boolean a4 = a(aVar, i2);
                JSONObject jSONObject = null;
                if (!(aVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                str = jSONObject.optString("content_type");
                JSONObject jSONObject2 = jSONObject;
                this.bNN.bkC = false;
                this.bNN.bkD = false;
                this.bNN.bkE = false;
                this.bNN.bkF = false;
                this.bNN.bkG = false;
                if (!"send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
                    this.bNN.bkC = true;
                    str2 = null;
                    str3 = null;
                } else if ("guard_seat".equals(str)) {
                    this.bNN.bkD = true;
                    str2 = null;
                    str3 = null;
                } else if ("guard_club_join".equals(str)) {
                    this.bNN.bkE = true;
                    str2 = null;
                    str3 = null;
                } else if ("haokan_buy_goods".equals(str)) {
                    this.bNN.bkF = true;
                    str2 = null;
                    str3 = null;
                } else if ("privilege_award_royal_success".equals(str)) {
                    this.bNN.bkG = true;
                    str2 = null;
                    str3 = null;
                } else if (!"audio_emoticon".equals(str) || jSONObject2 == null) {
                    str2 = null;
                    str3 = null;
                } else {
                    try {
                        jSONObject2.optJSONObject("emoticon_info").optString("compression_img");
                        String optString = jSONObject2.optJSONObject("emoticon_info").optString("prototype_img");
                        try {
                            str2 = jSONObject2.optJSONObject("emoticon_info").optString("result_img");
                            str3 = optString;
                        } catch (Exception e) {
                            str4 = optString;
                            exc = e;
                            exc.printStackTrace();
                            str2 = null;
                            str3 = str4;
                            this.bjx = a4;
                            aVar2.bgn = a3;
                            z = false;
                            if (aVar.getMsgType() != 24) {
                            }
                            z = true;
                            if (!z) {
                            }
                            aVar2.a(false, "", 0);
                            aVar2.bgk.setOnClickListener(null);
                            if (!(aVar instanceof com.baidu.live.im.a)) {
                            }
                            a2 = a(aVar, aVar2);
                            d = d(aVar.LO());
                            if (this.bjt) {
                            }
                            if (aVar instanceof com.baidu.live.im.a) {
                            }
                            aVar2.a(this.mContext, this.bNN);
                            aVar2.i(this.mContext, this.bNN.bkB);
                            aVar2.bgh.setHighlightColor(this.mContext.getResources().getColor(17170445));
                            aVar2.bgh.setMovementMethod(com.baidu.live.im.g.Lg());
                            if (this.bjs) {
                            }
                            aVar2.bgh.setText(a2);
                            if (!"audio_emoticon".equals(str)) {
                            }
                            aVar2.bNG.setVisibility(8);
                            return view;
                        }
                    } catch (Exception e2) {
                        exc = e2;
                        str4 = null;
                    }
                }
                this.bjx = a4;
                aVar2.bgn = a3;
                z = false;
                if (aVar.getMsgType() != 24 || aVar.getMsgType() == 1 || aVar.getMsgType() == 126) {
                    z = true;
                } else if ((aVar.getMsgType() == 13 || aVar.getMsgType() == 27) && (TextUtils.equals(str, "follow_anchor") || TextUtils.equals(str, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str, "share_tieba") || TextUtils.equals(str, "share_rmb") || TextUtils.equals(str, "zan_rmb") || TextUtils.equals(str, "audio_emoticon") || TextUtils.equals(str, "follow_anchor_phone") || TextUtils.equals(str, "follow_room"))) {
                    z = true;
                }
                if (!z && aVar.LO() != null && !TextUtils.isEmpty(aVar.LO().portrait)) {
                    aVar2.a(true, aVar.LO().portrait, i2);
                    aVar2.bgk.setOnClickListener(new c(aVar.LO(), this.mGroupId, this.mLiveId, this.bjr, this.aEz));
                } else {
                    aVar2.a(false, "", 0);
                    aVar2.bgk.setOnClickListener(null);
                }
                if (!(aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).bfW != null) {
                    a2 = ((com.baidu.live.im.a) aVar).bfW;
                } else {
                    a2 = a(aVar, aVar2);
                    d = d(aVar.LO());
                    if (this.bjt && d != null && a2 != null) {
                        a2.insert(0, (CharSequence) d);
                    }
                    if (aVar instanceof com.baidu.live.im.a) {
                        ((com.baidu.live.im.a) aVar).bfW = a2;
                    }
                }
                aVar2.a(this.mContext, this.bNN);
                aVar2.i(this.mContext, this.bNN.bkB);
                aVar2.bgh.setHighlightColor(this.mContext.getResources().getColor(17170445));
                aVar2.bgh.setMovementMethod(com.baidu.live.im.g.Lg());
                if (this.bjs) {
                    aVar2.bS(true);
                }
                aVar2.bgh.setText(a2);
                if (!"audio_emoticon".equals(str) && !StringUtils.isNull(str3, true) && !StringUtils.isNull(str2, true)) {
                    aVar2.bNG.setVisibility(0);
                    if (this.bNO.contains(Integer.valueOf(i))) {
                        aVar2.bNG.aM(null, str2);
                    } else {
                        this.bNO.add(Integer.valueOf(i));
                        aVar2.bNG.aM(str3, str2);
                    }
                } else {
                    aVar2.bNG.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        boolean a32 = a(aVar, aVar2, i2);
        boolean a42 = a(aVar, i2);
        JSONObject jSONObject3 = null;
        if (!(aVar.getObjContent() instanceof JSONObject)) {
        }
        str = jSONObject3.optString("content_type");
        JSONObject jSONObject22 = jSONObject3;
        this.bNN.bkC = false;
        this.bNN.bkD = false;
        this.bNN.bkE = false;
        this.bNN.bkF = false;
        this.bNN.bkG = false;
        if (!"send_redpacket".equals(str)) {
        }
        this.bNN.bkC = true;
        str2 = null;
        str3 = null;
        this.bjx = a42;
        aVar2.bgn = a32;
        z = false;
        if (aVar.getMsgType() != 24) {
        }
        z = true;
        if (!z) {
        }
        aVar2.a(false, "", 0);
        aVar2.bgk.setOnClickListener(null);
        if (!(aVar instanceof com.baidu.live.im.a)) {
        }
        a2 = a(aVar, aVar2);
        d = d(aVar.LO());
        if (this.bjt) {
            a2.insert(0, (CharSequence) d);
        }
        if (aVar instanceof com.baidu.live.im.a) {
        }
        aVar2.a(this.mContext, this.bNN);
        aVar2.i(this.mContext, this.bNN.bkB);
        aVar2.bgh.setHighlightColor(this.mContext.getResources().getColor(17170445));
        aVar2.bgh.setMovementMethod(com.baidu.live.im.g.Lg());
        if (this.bjs) {
        }
        aVar2.bgh.setText(a2);
        if (!"audio_emoticon".equals(str)) {
        }
        aVar2.bNG.setVisibility(8);
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.a aVar, com.baidu.live.yuyinim.a aVar2, int i) {
        JSONObject jSONObject;
        boolean z;
        bg bgVar;
        JSONObject jSONObject2 = null;
        String[] LV = aVar.LV();
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && (LV == null || LV.length == 0 || !TextUtils.equals(LV[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.z.a.Pq().bsy != null && (bgVar = com.baidu.live.z.a.Pq().bsy.aOC) != null && bgVar.aOe != null && LV != null && LV.length > 0 && !TextUtils.isEmpty(LV[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(LV[0], "guard_seat_effect"))) {
            jSONObject2 = bgVar.aOe.optJSONObject(LV[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                aVar2.aNj = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                aVar2.aNj = 255;
            }
            aVar2.bgo = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    aVar2.aNf = Color.parseColor(optString);
                    aVar2.aNg = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        aVar2.aNf = Color.parseColor(optString3);
                        aVar2.aNg = aVar2.aNf;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        aVar2.aNh = Color.parseColor(optString4);
                        aVar2.aNi = Color.parseColor(optString5);
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
    private boolean a(com.baidu.live.im.data.a aVar, int i) {
        JSONObject jSONObject;
        String optString;
        bg bgVar;
        int i2 = 255;
        String[] LV = aVar.LV();
        JSONObject jSONObject2 = null;
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && i >= 2) {
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
        } else if (com.baidu.live.z.a.Pq().bsy != null && (bgVar = com.baidu.live.z.a.Pq().bsy.aOC) != null && bgVar.aOf != null && LV != null && LV.length > 1 && !TextUtils.isEmpty(LV[1])) {
            jSONObject2 = bgVar.aOf.optJSONObject(LV[1]);
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
                this.bjv = Color.parseColor(optString2);
                this.bjw = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        bjp = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, String str) {
        this.bjt = true;
        a(spannableStringBuilder, aVar, aVar2, false, false, true, null, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2) {
        this.bjt = true;
        a(spannableStringBuilder, aVar, aVar2, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, aVar2, z, z2, z3, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3, String str, String str2) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bjt = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar3 = new a(aVar, this.mGroupId, this.mLiveId, this.bjr, this.aEz);
                aVar3.bjx = this.bjx;
                aVar3.bjv = this.bjv;
                aVar3.bjw = this.bjw;
                spannableString.setSpan(aVar3, 0, length, 17);
            } else {
                C0228b c0228b = new C0228b(aVar, this.mGroupId, this.mLiveId, this.bjr, this.aEz);
                c0228b.bjx = this.bjx;
                c0228b.bjv = this.bjv;
                c0228b.bjw = this.bjw;
                spannableString.setSpan(c0228b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            if (!TextUtils.isEmpty(str2)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str2;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.c cVar = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, false, new c.a() { // from class: com.baidu.live.yuyinim.a.b.1
                    @Override // com.baidu.live.view.c.a
                    public void d(Bitmap bitmap) {
                        b.this.Lz();
                    }

                    @Override // com.baidu.live.view.c.a
                    public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(cVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aGQ;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> v = v(list);
        if (ListUtils.isEmpty(v)) {
            return null;
        }
        int length = "[img] ".length();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < v.size(); i++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= v.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = v.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                if (1 == alaLiveMarkData.type) {
                    String str = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + aVar.level_id;
                    com.baidu.live.view.c cVar = com.baidu.live.view.c.bFL.get(str);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.bjs, new c.a() { // from class: com.baidu.live.yuyinim.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.Lz();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bFL.put(str, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = com.baidu.live.view.c.bFL.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.bjs, new c.a() { // from class: com.baidu.live.yuyinim.a.b.3
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.Lz();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bFL.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> v(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aEz)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int T(List<AlaLiveMarkData> list) {
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
    public void Lz() {
        long currentTimeMillis = System.currentTimeMillis() - this.bju;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bju = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.a.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bju = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bjr = z;
        this.aEz = str3;
    }

    public boolean LA() {
        return this.bjr;
    }

    /* renamed from: com.baidu.live.yuyinim.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0228b extends ClickableSpan implements g.a {
        private boolean aJi;
        private String aZS;
        private int bjv;
        private int bjw;
        private boolean bjx;
        private com.baidu.live.data.a bjz;
        private String groupId;
        private String liveId;

        C0228b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bjz = null;
            this.bjz = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aJi = z;
            this.aZS = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bjp) {
                if (this.bjx) {
                    textPaint.setColor(this.bjv);
                    textPaint.setAlpha(this.bjw);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bjp) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bjz instanceof com.baidu.live.data.a) {
                str = this.bjz.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bjz.userId, this.bjz.userName, this.bjz.portrait, this.bjz.sex, this.bjz.level_id, null, null, 0L, this.bjz.aGK, this.bjz.aGL, this.bjz.aGM, this.groupId, this.liveId, this.aJi, this.aZS, str, this.bjz.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Lh() {
            if (this.bjz != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bjz.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bjz));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aJi;
        private String aZS;
        private int bjv;
        private int bjw;
        private boolean bjx;
        private com.baidu.live.data.a bjz;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bjz = null;
            this.bjz = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aJi = z;
            this.aZS = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bjp) {
                if (this.bjx) {
                    textPaint.setColor(this.bjv);
                    textPaint.setAlpha(this.bjw);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bjp) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bjz instanceof com.baidu.live.data.a) {
                str = this.bjz.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bjz.userId, this.bjz.userName, this.bjz.portrait, this.bjz.sex, this.bjz.level_id, null, null, 0L, this.bjz.aGK, this.bjz.aGL, this.bjz.aGM, this.groupId, this.liveId, this.aJi, this.aZS, str, this.bjz.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Lh() {
            if (this.bjz != null) {
                if (this.bjz.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bjz));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements View.OnClickListener {
        private boolean aJi;
        private String aZS;
        private com.baidu.live.data.a bjz;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bjz = null;
            this.bjz = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aJi = z;
            this.aZS = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bjz.userId, this.bjz.userName, this.bjz.portrait, this.bjz.sex, this.bjz.level_id, null, null, 0L, this.bjz.aGK, this.bjz.aGL, this.bjz.aGM, this.groupId, this.liveId, this.aJi, this.aZS, this.bjz.appId, this.bjz.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean LC() {
        return 2 != bjp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void LD() {
        this.bNN.bkA = true;
        this.bNN.bkB = false;
        this.bNN.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void LE() {
        this.bNN.bkA = false;
        this.bNN.bkB = false;
        this.bNN.isNormal = false;
    }

    public void bW(boolean z) {
        this.bjs = z;
    }

    public void bX(boolean z) {
        this.bjt = z;
    }
}
