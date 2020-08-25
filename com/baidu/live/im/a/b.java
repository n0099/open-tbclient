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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ay;
import com.baidu.live.im.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.c;
import com.baidu.tbadk.TbConfig;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.a, com.baidu.live.im.c> {
    protected static int bbF = 1;
    private String aAE;
    protected com.baidu.live.im.e.a bbG;
    protected boolean bbH;
    protected boolean bbI;
    private boolean bbJ;
    private long bbK;
    private int bbL;
    private int bbM;
    private boolean bbN;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void Jy();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bbI = false;
        this.bbJ = false;
        this.bbK = 0L;
        this.bbG = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: n */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == bbF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(26:1|(2:3|(23:5|6|7|8|(1:10)(1:85)|11|12|(1:83)(2:16|(1:18)(2:74|(1:76)(2:77|(1:79)(2:80|(1:82)))))|19|(9:21|(1:72)(2:27|(1:45))|(1:71)(1:51)|52|(4:63|(1:67)|68|(1:70))(1:56)|57|(1:59)|60|61)|73|(1:47)|71|52|(1:54)|63|(1:67)|68|(0)|57|(0)|60|61))|88|6|7|8|(0)(0)|11|12|(1:14)|83|19|(0)|73|(0)|71|52|(0)|63|(0)|68|(0)|57|(0)|60|61) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0110, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[Catch: JSONException -> 0x010f, TryCatch #0 {JSONException -> 0x010f, blocks: (B:8:0x002a, B:10:0x0032, B:11:0x0038, B:42:0x0104), top: B:88:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104 A[Catch: JSONException -> 0x010f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x010f, blocks: (B:8:0x002a, B:10:0x0032, B:11:0x0038, B:42:0x0104), top: B:88:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c9  */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        int i2;
        String str;
        boolean z;
        SpannableStringBuilder a2;
        SpannableStringBuilder d;
        JSONObject jSONObject;
        this.bbJ = false;
        Jy();
        cVar.reset();
        if (aVar.JK() != null) {
            List<AlaLiveMarkData> list = aVar.JK().aCS;
            if (!ListUtils.isEmpty(list)) {
                i2 = N(list);
                boolean a3 = a(aVar, cVar, i2);
                boolean a4 = a(aVar, i2);
                if (!(aVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                str = jSONObject.optString("content_type");
                this.bbG.bcF = false;
                this.bbG.bcG = false;
                this.bbG.bcH = false;
                this.bbG.bcI = false;
                this.bbG.bcJ = false;
                if (!"send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
                    this.bbG.bcF = true;
                } else if ("guard_seat".equals(str)) {
                    this.bbG.bcG = true;
                } else if ("guard_club_join".equals(str)) {
                    this.bbG.bcH = true;
                } else if ("haokan_buy_goods".equals(str)) {
                    this.bbG.bcI = true;
                } else if ("privilege_award_royal_success".equals(str)) {
                    this.bbG.bcJ = true;
                }
                this.bbN = a4;
                cVar.aYO = a3;
                if (!aVar.JV()) {
                    if (aVar.getMsgType() == 24 || aVar.getMsgType() == 1 || aVar.getMsgType() == 126) {
                        z = true;
                    } else if ((aVar.getMsgType() == 13 || aVar.getMsgType() == 27) && (TextUtils.equals(str, "enter_live") || TextUtils.equals(str, "follow_anchor") || TextUtils.equals(str, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str, "share_tieba") || TextUtils.equals(str, "share_rmb") || TextUtils.equals(str, "zan_rmb") || TextUtils.equals(str, "add_tags_to_anchor"))) {
                        z = true;
                    }
                    if (!z && aVar.JK() != null && !TextUtils.isEmpty(aVar.JK().portrait)) {
                        cVar.a(true, aVar.JK().portrait, i2);
                        cVar.aYL.setOnClickListener(new c(aVar.JK(), this.mGroupId, this.mLiveId, this.bbH, this.aAE));
                    } else {
                        cVar.a(false, "", 0);
                        cVar.aYL.setOnClickListener(null);
                    }
                    if (!(aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).aYx != null) {
                        a2 = ((com.baidu.live.im.a) aVar).aYx;
                    } else {
                        a2 = a(aVar, cVar);
                        d = d(aVar.JK());
                        if (this.bbJ && d != null && a2 != null) {
                            a2.insert(0, (CharSequence) d);
                        }
                        if (aVar instanceof com.baidu.live.im.a) {
                            ((com.baidu.live.im.a) aVar).aYx = a2;
                        }
                    }
                    cVar.a(this.mContext, this.bbG);
                    cVar.i(this.mContext, this.bbG.bcE);
                    cVar.aYI.setHighlightColor(this.mContext.getResources().getColor(17170445));
                    cVar.aYI.setMovementMethod(com.baidu.live.im.g.Jc());
                    if (this.bbI) {
                        cVar.bL(true);
                    }
                    cVar.aYI.setText(a2);
                    return view;
                }
                z = false;
                if (!z) {
                }
                cVar.a(false, "", 0);
                cVar.aYL.setOnClickListener(null);
                if (!(aVar instanceof com.baidu.live.im.a)) {
                }
                a2 = a(aVar, cVar);
                d = d(aVar.JK());
                if (this.bbJ) {
                    a2.insert(0, (CharSequence) d);
                }
                if (aVar instanceof com.baidu.live.im.a) {
                }
                cVar.a(this.mContext, this.bbG);
                cVar.i(this.mContext, this.bbG.bcE);
                cVar.aYI.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.aYI.setMovementMethod(com.baidu.live.im.g.Jc());
                if (this.bbI) {
                }
                cVar.aYI.setText(a2);
                return view;
            }
        }
        i2 = 0;
        boolean a32 = a(aVar, cVar, i2);
        boolean a42 = a(aVar, i2);
        if (!(aVar.getObjContent() instanceof JSONObject)) {
        }
        str = jSONObject.optString("content_type");
        this.bbG.bcF = false;
        this.bbG.bcG = false;
        this.bbG.bcH = false;
        this.bbG.bcI = false;
        this.bbG.bcJ = false;
        if (!"send_redpacket".equals(str)) {
        }
        this.bbG.bcF = true;
        this.bbN = a42;
        cVar.aYO = a32;
        if (!aVar.JV()) {
        }
        z = false;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.aYL.setOnClickListener(null);
        if (!(aVar instanceof com.baidu.live.im.a)) {
        }
        a2 = a(aVar, cVar);
        d = d(aVar.JK());
        if (this.bbJ) {
        }
        if (aVar instanceof com.baidu.live.im.a) {
        }
        cVar.a(this.mContext, this.bbG);
        cVar.i(this.mContext, this.bbG.bcE);
        cVar.aYI.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.aYI.setMovementMethod(com.baidu.live.im.g.Jc());
        if (this.bbI) {
        }
        cVar.aYI.setText(a2);
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar, int i) {
        JSONObject jSONObject;
        boolean z;
        ay ayVar;
        JSONObject jSONObject2 = null;
        String[] JR = aVar.JR();
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && (JR == null || JR.length == 0 || !TextUtils.equals(JR[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.w.a.Nk().bka != null && (ayVar = com.baidu.live.w.a.Nk().bka.aJA) != null && ayVar.aJc != null && JR != null && JR.length > 0 && !TextUtils.isEmpty(JR[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(JR[0], "guard_seat_effect"))) {
            jSONObject2 = ayVar.aJc.optJSONObject(JR[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                cVar.aIc = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                cVar.aIc = 255;
            }
            cVar.aYP = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aHY = Color.parseColor(optString);
                    cVar.aHZ = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aHY = Color.parseColor(optString3);
                        cVar.aHZ = cVar.aHY;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        cVar.aIa = Color.parseColor(optString4);
                        cVar.aIb = Color.parseColor(optString5);
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
        ay ayVar;
        int i2 = 255;
        String[] JR = aVar.JR();
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
        } else if (com.baidu.live.w.a.Nk().bka != null && (ayVar = com.baidu.live.w.a.Nk().bka.aJA) != null && ayVar.aJd != null && JR != null && JR.length > 1 && !TextUtils.isEmpty(JR[1])) {
            jSONObject2 = ayVar.aJd.optJSONObject(JR[1]);
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
                this.bbL = Color.parseColor(optString2);
                this.bbM = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        bbF = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.bbJ = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bbJ = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.bbH, this.aAE);
                aVar2.bbN = this.bbN;
                aVar2.bbL = this.bbL;
                aVar2.bbM = this.bbM;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0174b c0174b = new C0174b(aVar, this.mGroupId, this.mLiveId, this.bbH, this.aAE);
                c0174b.bbN = this.bbN;
                c0174b.bbL = this.bbL;
                c0174b.bbM = this.bbM;
                spannableString.setSpan(c0174b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aCS;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> t = t(list);
        if (ListUtils.isEmpty(t)) {
            return null;
        }
        int length = "[img] ".length();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < t.size(); i++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= t.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = t.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                if (1 == alaLiveMarkData.type) {
                    String str = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + aVar.level_id;
                    com.baidu.live.view.c cVar = com.baidu.live.view.c.bsS.get(str);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.bbI, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.Jw();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bsS.put(str, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = com.baidu.live.view.c.bsS.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.bbI, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.Jw();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bsS.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> t(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aAE)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int N(List<AlaLiveMarkData> list) {
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
    public void Jw() {
        long currentTimeMillis = System.currentTimeMillis() - this.bbK;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bbK = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bbK = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bbH = z;
        this.aAE = str3;
    }

    public boolean Jx() {
        return this.bbH;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0174b extends ClickableSpan implements g.a {
        private boolean aEw;
        private String aSX;
        private int bbL;
        private int bbM;
        private boolean bbN;
        private com.baidu.live.data.a bbP;
        private String groupId;
        private String liveId;

        C0174b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bbP = null;
            this.bbP = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aEw = z;
            this.aSX = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bbF) {
                if (this.bbN) {
                    textPaint.setColor(this.bbL);
                    textPaint.setAlpha(this.bbM);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bbF) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bbP instanceof com.baidu.live.data.a) {
                str = this.bbP.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bbP.userId, this.bbP.userName, this.bbP.portrait, this.bbP.sex, this.bbP.level_id, null, null, 0L, this.bbP.aCM, this.bbP.aCN, this.bbP.aCO, this.groupId, this.liveId, this.aEw, this.aSX, str, this.bbP.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Jd() {
            if (this.bbP != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bbP.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bbP));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aEw;
        private String aSX;
        private int bbL;
        private int bbM;
        private boolean bbN;
        private com.baidu.live.data.a bbP;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bbP = null;
            this.bbP = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aEw = z;
            this.aSX = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bbF) {
                if (this.bbN) {
                    textPaint.setColor(this.bbL);
                    textPaint.setAlpha(this.bbM);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bbF) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bbP instanceof com.baidu.live.data.a) {
                str = this.bbP.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bbP.userId, this.bbP.userName, this.bbP.portrait, this.bbP.sex, this.bbP.level_id, null, null, 0L, this.bbP.aCM, this.bbP.aCN, this.bbP.aCO, this.groupId, this.liveId, this.aEw, this.aSX, str, this.bbP.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Jd() {
            if (this.bbP != null) {
                if (this.bbP.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bbP));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class c implements View.OnClickListener {
        private boolean aEw;
        private String aSX;
        private com.baidu.live.data.a bbP;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bbP = null;
            this.bbP = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aEw = z;
            this.aSX = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bbP.userId, this.bbP.userName, this.bbP.portrait, this.bbP.sex, this.bbP.level_id, null, null, 0L, this.bbP.aCM, this.bbP.aCN, this.bbP.aCO, this.groupId, this.liveId, this.aEw, this.aSX, this.bbP.appId, this.bbP.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Jz() {
        return 2 != bbF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void JA() {
        this.bbG.bcD = true;
        this.bbG.bcE = false;
        this.bbG.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void JB() {
        this.bbG.bcD = false;
        this.bbG.bcE = false;
        this.bbG.isNormal = false;
    }

    public void bP(boolean z) {
        this.bbI = z;
    }

    public void bQ(boolean z) {
        this.bbJ = z;
    }
}
