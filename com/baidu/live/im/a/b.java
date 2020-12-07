package com.baidu.live.im.a;

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
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.b;
import com.baidu.tbadk.TbConfig;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.b, com.baidu.live.im.c> {
    protected static int bnq = 1;
    private String aGk;
    protected com.baidu.live.im.e.a bnr;
    protected boolean bns;
    private String bnt;
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

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bnu = false;
        this.bnv = false;
        this.bnw = 0L;
        this.bnr = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: k */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == bnq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(33:1|(2:3|(28:5|6|7|8|(2:10|11)(1:114)|12|13|14|15|(1:19)|(1:109)(1:24)|25|(1:108)(2:29|(1:31)(2:99|(1:101)(2:102|(1:104)(2:105|(1:107)))))|32|(9:34|(1:97)(2:38|(1:(2:42|(1:44)(1:71)))(2:72|(1:96)))|(1:70)(1:50)|51|(4:62|(1:66)|67|(1:69))(1:55)|56|(1:58)|59|60)|98|(1:46)|70|51|(1:53)|62|(1:66)|67|(0)|56|(0)|59|60))|117|6|7|8|(0)(0)|12|13|14|15|(2:17|19)|(1:21)|109|25|(1:27)|108|32|(0)|98|(0)|70|51|(0)|62|(0)|67|(0)|56|(0)|59|60|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0245, code lost:
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013f, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0140, code lost:
        r3 = r0;
        r0 = "";
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0233 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d A[Catch: JSONException -> 0x013e, TRY_LEAVE, TryCatch #1 {JSONException -> 0x013e, blocks: (B:8:0x0025, B:10:0x002d, B:52:0x0133), top: B:118:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0133 A[Catch: JSONException -> 0x013e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {JSONException -> 0x013e, blocks: (B:8:0x0025, B:10:0x002d, B:52:0x0133), top: B:118:0x0025 }] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar) {
        int i2;
        String str;
        String str2;
        boolean a2;
        boolean z;
        SpannableStringBuilder a3;
        SpannableStringBuilder d;
        JSONObject jSONObject;
        this.bnv = false;
        Nx();
        cVar.reset();
        if (bVar.NU() != null) {
            List<AlaLiveMarkData> list = bVar.NU().aID;
            if (!ListUtils.isEmpty(list)) {
                i2 = U(list);
                if (!(bVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                String optString = jSONObject.optString("content_type");
                str = jSONObject.optString("level_id");
                str2 = optString;
                JSONObject jSONObject2 = jSONObject;
                if (!TextUtils.isEmpty(str) && JavaTypesHelper.toInt(str, 0) > 0) {
                    bVar.NU().level_id = JavaTypesHelper.toInt(str, 0);
                }
                if (str2 == null && str2.equals("activity_common_im") && jSONObject2 != null) {
                    a2 = a(jSONObject2.optJSONObject("content_data"), cVar);
                } else {
                    a2 = a(bVar, cVar, i2);
                }
                boolean a4 = a(bVar, i2);
                this.bnr.bpu = false;
                this.bnr.bpv = false;
                this.bnr.bpw = false;
                this.bnr.bpx = false;
                this.bnr.bpy = false;
                if (!"send_redpacket".equals(str2) || "start_grab_redpacket".equals(str2)) {
                    this.bnr.bpu = true;
                } else if ("guard_seat".equals(str2)) {
                    this.bnr.bpv = true;
                } else if ("guard_club_join".equals(str2)) {
                    this.bnr.bpw = true;
                } else if ("haokan_buy_goods".equals(str2)) {
                    this.bnr.bpx = true;
                } else if ("privilege_award_royal_success".equals(str2)) {
                    this.bnr.bpy = true;
                }
                this.bnz = a4;
                cVar.bkl = a2;
                if (!bVar.Of()) {
                    if (bVar.getMsgType() == 1 || bVar.getMsgType() == 126) {
                        z = true;
                    } else if (bVar.getMsgType() == 24) {
                        if (str2 != null && jSONObject2 != null) {
                            z = !jSONObject2.optString("content_type").equals("pk_send_props");
                        }
                    } else if ((bVar.getMsgType() == 13 || bVar.getMsgType() == 27) && (TextUtils.equals(str2, "enter_live") || TextUtils.equals(str2, "follow_anchor") || TextUtils.equals(str2, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str2, "share_tieba") || TextUtils.equals(str2, "share_rmb") || TextUtils.equals(str2, "zan_rmb") || TextUtils.equals(str2, "tying_gift") || TextUtils.equals(str2, "add_tags_to_anchor") || TextUtils.equals(str2, "remove_video") || TextUtils.equals(str2, "live_poke_back"))) {
                        z = true;
                    }
                    if (!z && bVar.NU() != null && !TextUtils.isEmpty(bVar.NU().portrait)) {
                        cVar.a(true, bVar.NU().portrait, i2);
                        cVar.bki.setOnClickListener(new c(bVar.NU(), this.mGroupId, this.mLiveId, this.bns, this.aGk));
                    } else {
                        cVar.a(false, "", 0);
                        cVar.bki.setOnClickListener(null);
                    }
                    if (!(bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).bjU != null) {
                        a3 = ((com.baidu.live.im.a) bVar).bjU;
                    } else {
                        a3 = a(bVar, cVar);
                        d = d(bVar.NU());
                        if (this.bnv && d != null && a3 != null) {
                            a3.insert(0, (CharSequence) d);
                        }
                        if (bVar instanceof com.baidu.live.im.a) {
                            ((com.baidu.live.im.a) bVar).bjU = a3;
                        }
                    }
                    cVar.a(this.mContext, this.bnr);
                    cVar.m(this.mContext, this.bnr.bpt);
                    cVar.bkf.setHighlightColor(this.mContext.getResources().getColor(17170445));
                    cVar.bkf.setMovementMethod(com.baidu.live.im.g.Na());
                    if (this.bnu) {
                        cVar.ce(true);
                    }
                    cVar.bkf.setText(a3);
                    return view;
                }
                z = false;
                if (!z) {
                }
                cVar.a(false, "", 0);
                cVar.bki.setOnClickListener(null);
                if (!(bVar instanceof com.baidu.live.im.a)) {
                }
                a3 = a(bVar, cVar);
                d = d(bVar.NU());
                if (this.bnv) {
                    a3.insert(0, (CharSequence) d);
                }
                if (bVar instanceof com.baidu.live.im.a) {
                }
                cVar.a(this.mContext, this.bnr);
                cVar.m(this.mContext, this.bnr.bpt);
                cVar.bkf.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.bkf.setMovementMethod(com.baidu.live.im.g.Na());
                if (this.bnu) {
                }
                cVar.bkf.setText(a3);
                return view;
            }
        }
        i2 = 0;
        if (!(bVar.getObjContent() instanceof JSONObject)) {
        }
        String optString2 = jSONObject.optString("content_type");
        str = jSONObject.optString("level_id");
        str2 = optString2;
        JSONObject jSONObject22 = jSONObject;
        if (!TextUtils.isEmpty(str)) {
            bVar.NU().level_id = JavaTypesHelper.toInt(str, 0);
        }
        if (str2 == null) {
        }
        a2 = a(bVar, cVar, i2);
        boolean a42 = a(bVar, i2);
        this.bnr.bpu = false;
        this.bnr.bpv = false;
        this.bnr.bpw = false;
        this.bnr.bpx = false;
        this.bnr.bpy = false;
        if (!"send_redpacket".equals(str2)) {
        }
        this.bnr.bpu = true;
        this.bnz = a42;
        cVar.bkl = a2;
        if (!bVar.Of()) {
        }
        z = false;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.bki.setOnClickListener(null);
        if (!(bVar instanceof com.baidu.live.im.a)) {
        }
        a3 = a(bVar, cVar);
        d = d(bVar.NU());
        if (this.bnv) {
        }
        if (bVar instanceof com.baidu.live.im.a) {
        }
        cVar.a(this.mContext, this.bnr);
        cVar.m(this.mContext, this.bnr.bpt);
        cVar.bkf.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.bkf.setMovementMethod(com.baidu.live.im.g.Na());
        if (this.bnu) {
        }
        cVar.bkf.setText(a3);
        return view;
    }

    protected boolean a(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z = true;
        String optString = jSONObject.optString("start_bg_color");
        String optString2 = jSONObject.optString("end_bg_color");
        double optDouble = jSONObject.optDouble("alpha");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            cVar.aPw = Color.parseColor(optString.trim());
            cVar.aPx = Color.parseColor(optString2.trim());
        } else {
            String optString3 = jSONObject.optString("bg_color");
            if (TextUtils.isEmpty(optString3)) {
                z = false;
            } else {
                cVar.aPw = Color.parseColor(optString3);
                cVar.aPx = cVar.aPw;
            }
        }
        if (optDouble >= 0.0d && optDouble <= 1.0d) {
            cVar.aPA = (int) (255.0d * optDouble);
        } else {
            cVar.aPA = 255;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.b bVar, com.baidu.live.im.c cVar, int i) {
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
                cVar.aPA = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                cVar.aPA = 255;
            }
            cVar.bkm = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aPw = Color.parseColor(optString);
                    cVar.aPx = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aPw = Color.parseColor(optString3);
                        cVar.aPx = cVar.aPw;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        cVar.aPy = Color.parseColor(optString4);
                        cVar.aPz = Color.parseColor(optString5);
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
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.bnv = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bnv = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.bns, this.aGk);
                aVar2.bnz = this.bnz;
                aVar2.bnx = this.bnx;
                aVar2.bny = this.bny;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0191b c0191b = new C0191b(aVar, this.mGroupId, this.mLiveId, this.bns, this.aGk);
                c0191b.bnz = this.bnz;
                c0191b.bnx = this.bnx;
                c0191b.bny = this.bny;
                spannableString.setSpan(c0191b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
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
        for (int i = 0; i < w.size(); i++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= w.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = w.get(i3);
            if (alaLiveMarkData != null) {
                alaLiveMarkData.userLevel = aVar.level_id;
                alaLiveMarkData.setupNewLevelMark();
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                if (alaLiveMarkData.isGuardType()) {
                    if (TextUtils.isEmpty(alaLiveMarkData.guardName)) {
                        alaLiveMarkData.guardName = this.bnt;
                    }
                    String str = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + alaLiveMarkData.level + "*_*" + alaLiveMarkData.guardName + "*_*" + (alaLiveMarkData.isGold() ? "1" : "0") + "*_*" + alaLiveMarkData.guardGoldenType;
                    com.baidu.live.view.b bVar = com.baidu.live.view.b.bON.get(str);
                    if (bVar == null) {
                        if (alaLiveMarkData.level <= 0) {
                            alaLiveMarkData.level = com.baidu.live.guardclub.g.LZ().hU(alaLiveMarkData.mark_pic);
                        }
                        Bitmap a2 = com.baidu.live.ak.b.a(this.mContext, alaLiveMarkData.guardName, alaLiveMarkData.level, 0, a.d.sdk_ds32, alaLiveMarkData.isGold(), alaLiveMarkData.guardGoldenType);
                        if (a2 != null) {
                            bVar = new com.baidu.live.view.b(this.mContext, a2);
                            com.baidu.live.view.b.bON.put(str, bVar);
                        }
                    }
                    spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.b bVar2 = com.baidu.live.view.b.bON.get(genCacheKey);
                    if (bVar2 == null) {
                        bVar2 = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bnu, new b.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.b.a
                            public void d(Bitmap bitmap) {
                                b.this.Nv();
                            }

                            @Override // com.baidu.live.view.b.a
                            public void a(com.baidu.live.view.b bVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.b.bON.put(genCacheKey, bVar2);
                    }
                    spannableStringBuilder.setSpan(bVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
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
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bnw = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bns = z;
        this.aGk = str3;
        this.bnt = str4;
    }

    public boolean Nw() {
        return this.bns;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0191b extends ClickableSpan implements g.a {
        private boolean aLj;
        private String bcY;
        private com.baidu.live.data.a bnB;
        private int bnx;
        private int bny;
        private boolean bnz;
        private String groupId;
        private String liveId;

        C0191b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bnB.userId, this.bnB.userName, this.bnB.portrait, this.bnB.sex, this.bnB.level_id, null, null, 0L, this.bnB.aIx, this.bnB.aIy, this.bnB.aIz, this.groupId, this.liveId, this.aLj, this.bcY, str, this.bnB.getNameShow(), "")));
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bnB.userId, this.bnB.userName, this.bnB.portrait, this.bnB.sex, this.bnB.level_id, null, null, 0L, this.bnB.aIx, this.bnB.aIy, this.bnB.aIz, this.groupId, this.liveId, this.aLj, this.bcY, str, this.bnB.getNameShow(), "")));
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bnB.userId, this.bnB.userName, this.bnB.portrait, this.bnB.sex, this.bnB.level_id, null, null, 0L, this.bnB.aIx, this.bnB.aIy, this.bnB.aIz, this.groupId, this.liveId, this.aLj, this.bcY, this.bnB.appId, this.bnB.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ny() {
        return 2 != bnq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nz() {
        this.bnr.bps = true;
        this.bnr.bpt = false;
        this.bnr.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NA() {
        this.bnr.bps = false;
        this.bnr.bpt = false;
        this.bnr.isNormal = false;
    }

    public void ci(boolean z) {
        this.bnu = z;
    }

    public void cj(boolean z) {
        this.bnv = z;
    }
}
