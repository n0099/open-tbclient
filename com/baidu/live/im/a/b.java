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
import com.baidu.live.data.aj;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.c;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.a, com.baidu.live.im.c> {
    protected static int asP = 1;
    protected d asQ;
    private boolean asR;
    private String asS;
    protected boolean asT;
    private boolean asU;
    private long asV;
    private int asW;
    private int asX;
    private boolean asY;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    /* loaded from: classes3.dex */
    public interface c {
        void wT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class d {
        public boolean atb = false;
        public boolean atc = true;
        public boolean isNormal = true;
        public boolean atd = false;
        public boolean ate = false;
    }

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    protected abstract void wP();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.asT = false;
        this.asU = false;
        this.asV = 0L;
        this.asQ = new d();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: f */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == asP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e8  */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        boolean z;
        String str;
        SpannableStringBuilder spannableStringBuilder;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        String optString;
        String optString2;
        int i2;
        this.asU = false;
        wP();
        String[] xv = aVar.xv();
        boolean z2 = false;
        boolean z3 = false;
        cVar.reset();
        if (xv == null || xv.length <= 1 || com.baidu.live.v.a.zl().axC == null) {
            z = false;
        } else {
            aj ajVar = com.baidu.live.v.a.zl().axC.acU;
            if (ajVar != null && ajVar.acu != null && !TextUtils.isEmpty(xv[0])) {
                if (TbadkCoreApplication.getInst().isMobileBaidu() && xv[0].equals("guard_seat_effect")) {
                    xv[0] = "";
                }
                JSONObject optJSONObject2 = ajVar.acu.optJSONObject(xv[0]);
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("transparency");
                    if (optInt >= 0 && optInt <= 100) {
                        cVar.abr = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                    } else {
                        cVar.abr = 255;
                    }
                    cVar.abt = optJSONObject2.optString("tail_icon");
                    String optString3 = optJSONObject2.optString("start_color");
                    String optString4 = optJSONObject2.optString("end_color");
                    try {
                        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                            cVar.abn = Color.parseColor(optString3);
                            cVar.abo = Color.parseColor(optString4);
                            z2 = true;
                        } else {
                            String optString5 = optJSONObject2.optString("bg_color");
                            if (!TextUtils.isEmpty(optString5)) {
                                cVar.abn = Color.parseColor(optString5);
                                cVar.abo = cVar.abn;
                                z2 = true;
                            }
                        }
                        if (z2) {
                            String optString6 = optJSONObject2.optString("frame_start_color");
                            String optString7 = optJSONObject2.optString("frame_end_color");
                            if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
                                cVar.abp = Color.parseColor(optString6);
                                cVar.abq = Color.parseColor(optString7);
                            }
                        }
                        z = z2;
                    } catch (Exception e) {
                        z = false;
                        e.printStackTrace();
                    }
                    if (ajVar != null && ajVar.acv != null && !TextUtils.isEmpty(xv[1]) && (optJSONObject = ajVar.acv.optJSONObject(xv[1])) != null) {
                        optString = optJSONObject.optString("bg_color");
                        if (TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                            try {
                                i2 = (int) (((Integer.parseInt(optString2) * 1.0f) / 100.0f) * 255.0f);
                            } catch (Exception e2) {
                                i2 = 255;
                            }
                        } else {
                            i2 = 255;
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            z3 = true;
                            this.asW = Color.parseColor(optString);
                            this.asX = i2;
                        }
                    }
                }
            }
            z = false;
            if (ajVar != null) {
                optString = optJSONObject.optString("bg_color");
                if (TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                }
                if (!TextUtils.isEmpty(optString)) {
                }
            }
        }
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            str = jSONObject.optString("content_type");
        } catch (JSONException e3) {
            str = null;
        }
        this.asQ.atd = false;
        this.asQ.ate = false;
        if ("send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
            this.asQ.atd = true;
            cVar.abn = Color.parseColor("#FFFF5D67");
            cVar.abo = cVar.abn;
            cVar.abr = 1;
        } else if ("guard_seat".equals(str)) {
            this.asQ.ate = true;
        }
        this.asY = z3;
        cVar.aqR = z;
        if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).aqB != null) {
            spannableStringBuilder = ((com.baidu.live.im.a) aVar).aqB;
        } else {
            SpannableStringBuilder a2 = a(aVar, cVar);
            SpannableStringBuilder a3 = a(aVar.xo());
            if (this.asU && a3 != null && a2 != null) {
                a2.insert(0, (CharSequence) a3);
            }
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).aqB = a2;
            }
            spannableStringBuilder = a2;
        }
        cVar.a(this.mContext, this.asQ.atb, this.asQ.isNormal, this.asQ.atd, this.asQ.ate);
        cVar.g(this.mContext, this.asQ.atc);
        cVar.aqO.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.aqO.setMovementMethod(com.baidu.live.im.g.wo());
        if (this.asT) {
            cVar.aQ(true);
        }
        cVar.aqO.setText(spannableStringBuilder);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        asP = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.asU = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.asU = true;
            String format = String.format(!z3 ? "%s " : "%s：", z ? this.mContext.getString(a.i.ala_host) : aVar.getNameShow());
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                spannableString.setSpan(new a(aVar, this.mGroupId, this.mLiveId, this.asR, this.asS), 0, length, 17);
            } else {
                C0088b c0088b = new C0088b(aVar, this.mGroupId, this.mLiveId, this.asR, this.asS);
                c0088b.asY = this.asY;
                c0088b.asW = this.asW;
                c0088b.asX = this.asX;
                spannableString.setSpan(c0088b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder a(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.Xl;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> D = D(list);
        if (ListUtils.isEmpty(D)) {
            return null;
        }
        String str = "  ";
        if (this.asT) {
            str = "  ";
        }
        int length = str.length();
        String str2 = "";
        for (int i = 0; i < D.size(); i++) {
            str2 = str + str2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= D.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = D.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = i4 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str3 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + aVar.level_id;
                    com.baidu.live.view.c cVar = ALaImInitialize.arn.get(str3);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.asT, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.wN();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.arn.put(str3, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = ALaImInitialize.arn.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.asT, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.wN();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.arn.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> D(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.asS)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 5 ? linkedList.subList(0, 5) : linkedList;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN() {
        long currentTimeMillis = System.currentTimeMillis() - this.asV;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.asV = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.asV = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.asR = z;
        this.asS = str3;
    }

    public boolean wO() {
        return this.asR;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0088b extends ClickableSpan implements c {
        private boolean Yr;
        private String alD;
        private int asW;
        private int asX;
        private boolean asY;
        private com.baidu.live.data.a ata;
        private String groupId;
        private String liveId;

        C0088b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.ata = null;
            this.ata = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.Yr = z;
            this.alD = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.asP) {
                if (this.asY) {
                    textPaint.setColor(this.asW);
                    textPaint.setAlpha(this.asX);
                } else {
                    textPaint.setColor(-1647769);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.asP) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.ata instanceof com.baidu.live.data.a) {
                str = this.ata.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.ata.userId, this.ata.userName, this.ata.portrait, this.ata.sex, this.ata.level_id, null, null, 0L, this.ata.Xf, this.ata.Xg, this.ata.Xh, this.groupId, this.liveId, this.Yr, this.alD, str, this.ata.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void wT() {
            if (this.ata != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.ata.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.ata));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends ClickableSpan implements c {
        private boolean Yr;
        private String alD;
        private com.baidu.live.data.a ata;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.ata = null;
            this.ata = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.Yr = z;
            this.alD = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.asP) {
                textPaint.setColor(-1647769);
            } else if (2 == b.asP) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.ata instanceof com.baidu.live.data.a) {
                str = this.ata.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.ata.userId, this.ata.userName, this.ata.portrait, this.ata.sex, this.ata.level_id, null, null, 0L, this.ata.Xf, this.ata.Xg, this.ata.Xh, this.groupId, this.liveId, this.Yr, this.alD, str, this.ata.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void wT() {
            if (this.ata != null) {
                if (this.ata.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.ata));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wQ() {
        return 2 != asP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wR() {
        this.asQ.atb = true;
        this.asQ.atc = false;
        this.asQ.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wS() {
        this.asQ.atb = false;
        this.asQ.atc = false;
        this.asQ.isNormal = false;
    }

    public void aV(boolean z) {
        this.asT = z;
    }
}
