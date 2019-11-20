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
import com.baidu.live.data.ab;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.c;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.a, com.baidu.live.im.c> {
    protected static int agJ = 1;
    protected d agK;
    private boolean agL;
    private String agM;
    protected boolean agN;
    private boolean agO;
    private long agP;
    private int agQ;
    private int agR;
    private boolean agS;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    /* loaded from: classes6.dex */
    public interface c {
        void te();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static class d {
        public boolean agV = false;
        public boolean agW = true;
        public boolean isNormal = true;
    }

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    protected abstract void ta();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.agN = false;
        this.agO = false;
        this.agP = 0L;
        this.agK = new d();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: f */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == agJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        boolean z;
        boolean z2;
        SpannableStringBuilder a2;
        boolean z3;
        JSONObject optJSONObject;
        String optString;
        String optString2;
        JSONObject optJSONObject2;
        String optString3;
        int i2;
        int i3 = 255;
        this.agO = false;
        ta();
        String[] tl = aVar.tl();
        if (tl == null || tl.length <= 1 || com.baidu.live.l.a.uB().aku == null) {
            z = false;
            z2 = false;
        } else {
            ab abVar = com.baidu.live.l.a.uB().aku.TM;
            if (abVar != null && abVar.Tt != null && !TextUtils.isEmpty(tl[0]) && (optJSONObject2 = abVar.Tt.optJSONObject(tl[0])) != null) {
                String optString4 = optJSONObject2.optString("bg_color");
                if (TextUtils.isEmpty(optJSONObject2.optString("transparency"))) {
                    i2 = 255;
                } else {
                    try {
                        i2 = (int) (((Integer.parseInt(optString3) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e) {
                        i2 = 255;
                    }
                }
                if (!TextUtils.isEmpty(optString4)) {
                    cVar.color = Color.parseColor(optString4);
                    cVar.alpha = i2;
                    z3 = true;
                    if (abVar != null && abVar.Tu != null && !TextUtils.isEmpty(tl[1]) && (optJSONObject = abVar.Tu.optJSONObject(tl[1])) != null) {
                        optString = optJSONObject.optString("bg_color");
                        if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                            try {
                                i3 = (int) (((Integer.parseInt(optString2) * 1.0f) / 100.0f) * 255.0f);
                            } catch (Exception e2) {
                            }
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            this.agQ = Color.parseColor(optString);
                            this.agR = i3;
                            z2 = z3;
                            z = true;
                        }
                    }
                    z2 = z3;
                    z = false;
                }
            }
            z3 = false;
            if (abVar != null) {
                optString = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                }
                if (!TextUtils.isEmpty(optString)) {
                }
            }
            z2 = z3;
            z = false;
        }
        this.agS = z;
        cVar.aeK = z2;
        if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).aew != null) {
            a2 = ((com.baidu.live.im.a) aVar).aew;
        } else {
            a2 = a(aVar, cVar);
            SpannableStringBuilder a3 = a(aVar.tf());
            if (this.agO && a3 != null && a2 != null) {
                a2.insert(0, (CharSequence) a3);
            }
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).aew = a2;
            }
        }
        cVar.b(this.mContext, this.agK.agV, this.agK.isNormal);
        cVar.g(this.mContext, this.agK.agW);
        cVar.aeI.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.aeI.setMovementMethod(com.baidu.live.im.g.sC());
        if (this.agN) {
            cVar.au(true);
        }
        cVar.aeI.setText(a2);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        agJ = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.agO = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.agO = true;
            String format = String.format(!z3 ? "%s " : "%s：", z ? this.mContext.getString(a.i.ala_host) : aVar.getNameShow());
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                spannableString.setSpan(new a(aVar, this.mGroupId, this.mLiveId, this.agL, this.agM), 0, length, 17);
            } else {
                C0067b c0067b = new C0067b(aVar, this.mGroupId, this.mLiveId, this.agL, this.agM);
                c0067b.agS = this.agS;
                c0067b.agQ = this.agQ;
                c0067b.agR = this.agR;
                spannableString.setSpan(c0067b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder a(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.Op;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> G = G(list);
        if (ListUtils.isEmpty(G)) {
            return null;
        }
        String str = "  ";
        if (this.agN) {
            str = "  ";
        }
        int length = str.length();
        String str2 = "";
        for (int i = 0; i < G.size(); i++) {
            str2 = str + str2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= G.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = G.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = i4 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str3 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + aVar.level_id;
                    com.baidu.live.view.c cVar = ALaImInitialize.afg.get(str3);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.agN, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.sZ();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.afg.put(str3, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = ALaImInitialize.afg.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.agN, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.sZ();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.afg.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> G(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.agM)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 4 ? linkedList.subList(0, 4) : linkedList;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ() {
        long currentTimeMillis = System.currentTimeMillis() - this.agP;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.agP = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.agP = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.agL = z;
        this.agM = str3;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0067b extends ClickableSpan implements c {
        private boolean Pr;
        private String aaH;
        private int agQ;
        private int agR;
        private boolean agS;
        private com.baidu.live.data.a agU;
        private String groupId;
        private String liveId;

        C0067b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.agU = null;
            this.agU = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.Pr = z;
            this.aaH = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.agJ) {
                if (this.agS) {
                    textPaint.setColor(this.agQ);
                    textPaint.setAlpha(this.agR);
                } else {
                    textPaint.setColor(-1647769);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.agJ) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.agU instanceof com.baidu.live.data.a) {
                str = this.agU.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.agU.userId, this.agU.userName, this.agU.portrait, this.agU.sex, this.agU.level_id, null, null, 0L, this.agU.Oj, this.agU.Ok, this.agU.Ol, this.groupId, this.liveId, this.Pr, this.aaH, str, this.agU.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void te() {
            if (this.agU != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.agU.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.agU));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends ClickableSpan implements c {
        private boolean Pr;
        private String aaH;
        private com.baidu.live.data.a agU;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.agU = null;
            this.agU = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.Pr = z;
            this.aaH = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.agJ) {
                textPaint.setColor(-1647769);
            } else if (2 == b.agJ) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.agU instanceof com.baidu.live.data.a) {
                str = this.agU.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.agU.userId, this.agU.userName, this.agU.portrait, this.agU.sex, this.agU.level_id, null, null, 0L, this.agU.Oj, this.agU.Ok, this.agU.Ol, this.groupId, this.liveId, this.Pr, this.aaH, str, this.agU.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void te() {
            if (this.agU != null) {
                if (this.agU.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.agU));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean tb() {
        return 2 != agJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tc() {
        this.agK.agV = true;
        this.agK.agW = false;
        this.agK.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void td() {
        this.agK.agV = false;
        this.agK.agW = false;
        this.agK.isNormal = false;
    }

    public void az(boolean z) {
        this.agN = z;
    }
}
