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
import com.baidu.live.data.aw;
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
/* loaded from: classes4.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.a, com.baidu.live.im.c> {
    protected static int aWq = 1;
    protected com.baidu.live.im.e.a aWr;
    protected boolean aWs;
    protected boolean aWt;
    private boolean aWu;
    private long aWv;
    private int aWw;
    private int aWx;
    private boolean aWy;
    private String avC;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void DV();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aWt = false;
        this.aWu = false;
        this.aWv = 0L;
        this.aWr = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: m */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == aWq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(26:1|(2:3|(17:5|6|7|8|(1:10)(1:79)|11|12|(1:77)(2:16|(1:18)(2:68|(1:70)(2:71|(1:73)(2:74|(1:76)))))|19|(1:67)(2:25|(1:66)(1:29))|(1:55)(1:35)|36|(4:47|(1:51)|52|(1:54))(1:40)|41|(1:43)|44|45))|82|6|7|8|(0)(0)|11|12|(1:14)|77|19|(1:21)|67|(1:31)|55|36|(1:38)|47|(1:51)|52|(0)|41|(0)|44|45) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[Catch: JSONException -> 0x0109, TryCatch #0 {JSONException -> 0x0109, blocks: (B:8:0x002a, B:10:0x0032, B:11:0x0038, B:40:0x00fe), top: B:82:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe A[Catch: JSONException -> 0x0109, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0109, blocks: (B:8:0x002a, B:10:0x0032, B:11:0x0038, B:40:0x00fe), top: B:82:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b1  */
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
        this.aWu = false;
        DV();
        cVar.reset();
        if (aVar.Eh() != null) {
            List<AlaLiveMarkData> list = aVar.Eh().axQ;
            if (!ListUtils.isEmpty(list)) {
                i2 = M(list);
                boolean a3 = a(aVar, cVar, i2);
                boolean a4 = a(aVar, i2);
                if (!(aVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                str = jSONObject.optString("content_type");
                this.aWr.aXp = false;
                this.aWr.aXq = false;
                this.aWr.aXr = false;
                this.aWr.aXs = false;
                this.aWr.aXt = false;
                if (!"send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
                    this.aWr.aXp = true;
                } else if ("guard_seat".equals(str)) {
                    this.aWr.aXq = true;
                } else if ("guard_club_join".equals(str)) {
                    this.aWr.aXr = true;
                } else if ("haokan_buy_goods".equals(str)) {
                    this.aWr.aXs = true;
                } else if ("privilege_award_royal_success".equals(str)) {
                    this.aWr.aXt = true;
                }
                this.aWy = a4;
                cVar.aTA = a3;
                if (aVar.getMsgType() != 24 || aVar.getMsgType() == 1 || aVar.getMsgType() == 126) {
                    z = true;
                } else {
                    z = (aVar.getMsgType() == 13 || aVar.getMsgType() == 27) && (TextUtils.equals(str, "follow_anchor") || TextUtils.equals(str, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str, "share_tieba") || TextUtils.equals(str, "share_rmb") || TextUtils.equals(str, "zan_rmb"));
                }
                if (!z && aVar.Eh() != null && !TextUtils.isEmpty(aVar.Eh().portrait)) {
                    cVar.a(true, aVar.Eh().portrait, i2);
                    cVar.aTx.setOnClickListener(new c(aVar.Eh(), this.mGroupId, this.mLiveId, this.aWs, this.avC));
                } else {
                    cVar.a(false, "", 0);
                    cVar.aTx.setOnClickListener(null);
                }
                if (!(aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).aTj != null) {
                    a2 = ((com.baidu.live.im.a) aVar).aTj;
                } else {
                    a2 = a(aVar, cVar);
                    d = d(aVar.Eh());
                    if (this.aWu && d != null && a2 != null) {
                        a2.insert(0, (CharSequence) d);
                    }
                    if (aVar instanceof com.baidu.live.im.a) {
                        ((com.baidu.live.im.a) aVar).aTj = a2;
                    }
                }
                cVar.a(this.mContext, this.aWr);
                cVar.i(this.mContext, this.aWr.aXo);
                cVar.aTu.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.aTu.setMovementMethod(com.baidu.live.im.g.Dz());
                if (this.aWt) {
                    cVar.bG(true);
                }
                cVar.aTu.setText(a2);
                return view;
            }
        }
        i2 = 0;
        boolean a32 = a(aVar, cVar, i2);
        boolean a42 = a(aVar, i2);
        if (!(aVar.getObjContent() instanceof JSONObject)) {
        }
        str = jSONObject.optString("content_type");
        this.aWr.aXp = false;
        this.aWr.aXq = false;
        this.aWr.aXr = false;
        this.aWr.aXs = false;
        this.aWr.aXt = false;
        if (!"send_redpacket".equals(str)) {
        }
        this.aWr.aXp = true;
        this.aWy = a42;
        cVar.aTA = a32;
        if (aVar.getMsgType() != 24) {
        }
        z = true;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.aTx.setOnClickListener(null);
        if (!(aVar instanceof com.baidu.live.im.a)) {
        }
        a2 = a(aVar, cVar);
        d = d(aVar.Eh());
        if (this.aWu) {
            a2.insert(0, (CharSequence) d);
        }
        if (aVar instanceof com.baidu.live.im.a) {
        }
        cVar.a(this.mContext, this.aWr);
        cVar.i(this.mContext, this.aWr.aXo);
        cVar.aTu.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.aTu.setMovementMethod(com.baidu.live.im.g.Dz());
        if (this.aWt) {
        }
        cVar.aTu.setText(a2);
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
        aw awVar;
        JSONObject jSONObject2 = null;
        String[] Eo = aVar.Eo();
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && (Eo == null || Eo.length == 0 || !TextUtils.equals(Eo[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.v.a.Hs().beo != null && (awVar = com.baidu.live.v.a.Hs().beo.aEq) != null && awVar.aDS != null && Eo != null && Eo.length > 0 && !TextUtils.isEmpty(Eo[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(Eo[0], "guard_seat_effect"))) {
            jSONObject2 = awVar.aDS.optJSONObject(Eo[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                cVar.aCS = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                cVar.aCS = 255;
            }
            cVar.aTB = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aCO = Color.parseColor(optString);
                    cVar.aCP = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aCO = Color.parseColor(optString3);
                        cVar.aCP = cVar.aCO;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        cVar.aCQ = Color.parseColor(optString4);
                        cVar.aCR = Color.parseColor(optString5);
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
        aw awVar;
        int i2 = 255;
        String[] Eo = aVar.Eo();
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
        } else if (com.baidu.live.v.a.Hs().beo != null && (awVar = com.baidu.live.v.a.Hs().beo.aEq) != null && awVar.aDT != null && Eo != null && Eo.length > 1 && !TextUtils.isEmpty(Eo[1])) {
            jSONObject2 = awVar.aDT.optJSONObject(Eo[1]);
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
                this.aWw = Color.parseColor(optString2);
                this.aWx = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        aWq = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.aWu = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.aWu = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.aWs, this.avC);
                aVar2.aWy = this.aWy;
                aVar2.aWw = this.aWw;
                aVar2.aWx = this.aWx;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0166b c0166b = new C0166b(aVar, this.mGroupId, this.mLiveId, this.aWs, this.avC);
                c0166b.aWy = this.aWy;
                c0166b.aWw = this.aWw;
                c0166b.aWx = this.aWx;
                spannableString.setSpan(c0166b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.axQ;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> s = s(list);
        if (ListUtils.isEmpty(s)) {
            return null;
        }
        int length = "[img] ".length();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.size(); i++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= s.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = s.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                if (1 == alaLiveMarkData.type) {
                    String str = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + aVar.level_id;
                    com.baidu.live.view.c cVar = com.baidu.live.view.c.bnn.get(str);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.aWt, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.DT();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bnn.put(str, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = com.baidu.live.view.c.bnn.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.aWt, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.DT();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bnn.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> s(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.avC)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int M(List<AlaLiveMarkData> list) {
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
    public void DT() {
        long currentTimeMillis = System.currentTimeMillis() - this.aWv;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.aWv = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.aWv = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aWs = z;
        this.avC = str3;
    }

    public boolean DU() {
        return this.aWs;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0166b extends ClickableSpan implements g.a {
        private String aNK;
        private com.baidu.live.data.a aWA;
        private int aWw;
        private int aWx;
        private boolean aWy;
        private boolean azm;
        private String groupId;
        private String liveId;

        C0166b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.aWA = null;
            this.aWA = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.azm = z;
            this.aNK = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.aWq) {
                if (this.aWy) {
                    textPaint.setColor(this.aWw);
                    textPaint.setAlpha(this.aWx);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.aWq) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.aWA instanceof com.baidu.live.data.a) {
                str = this.aWA.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.aWA.userId, this.aWA.userName, this.aWA.portrait, this.aWA.sex, this.aWA.level_id, null, null, 0L, this.aWA.axK, this.aWA.axL, this.aWA.axM, this.groupId, this.liveId, this.azm, this.aNK, str, this.aWA.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void DA() {
            if (this.aWA != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.aWA.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aWA));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ClickableSpan implements g.a {
        private String aNK;
        private com.baidu.live.data.a aWA;
        private int aWw;
        private int aWx;
        private boolean aWy;
        private boolean azm;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.aWA = null;
            this.aWA = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.azm = z;
            this.aNK = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.aWq) {
                if (this.aWy) {
                    textPaint.setColor(this.aWw);
                    textPaint.setAlpha(this.aWx);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.aWq) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.aWA instanceof com.baidu.live.data.a) {
                str = this.aWA.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.aWA.userId, this.aWA.userName, this.aWA.portrait, this.aWA.sex, this.aWA.level_id, null, null, 0L, this.aWA.axK, this.aWA.axL, this.aWA.axM, this.groupId, this.liveId, this.azm, this.aNK, str, this.aWA.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void DA() {
            if (this.aWA != null) {
                if (this.aWA.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aWA));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements View.OnClickListener {
        private String aNK;
        private com.baidu.live.data.a aWA;
        private boolean azm;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.aWA = null;
            this.aWA = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.azm = z;
            this.aNK = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.aWA.userId, this.aWA.userName, this.aWA.portrait, this.aWA.sex, this.aWA.level_id, null, null, 0L, this.aWA.axK, this.aWA.axL, this.aWA.axM, this.groupId, this.liveId, this.azm, this.aNK, this.aWA.appId, this.aWA.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DW() {
        return 2 != aWq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DX() {
        this.aWr.aXn = true;
        this.aWr.aXo = false;
        this.aWr.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DY() {
        this.aWr.aXn = false;
        this.aWr.aXo = false;
        this.aWr.isNormal = false;
    }

    public void bJ(boolean z) {
        this.aWt = z;
    }

    public void bK(boolean z) {
        this.aWu = z;
    }
}
