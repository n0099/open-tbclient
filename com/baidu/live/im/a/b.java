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
    protected static int ata = 1;
    protected d atb;
    private boolean atc;
    private String atd;
    protected boolean ate;
    private boolean atf;
    private long atg;
    private int ath;
    private int ati;
    private boolean atj;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    /* loaded from: classes3.dex */
    public interface c {
        void wY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class d {
        public boolean atm = false;
        public boolean atn = true;
        public boolean isNormal = true;
        public boolean ato = false;
        public boolean atp = false;
    }

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    protected abstract void wU();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.ate = false;
        this.atf = false;
        this.atg = 0L;
        this.atb = new d();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: f */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == ata);
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
        this.atf = false;
        wU();
        String[] xA = aVar.xA();
        boolean z2 = false;
        boolean z3 = false;
        cVar.reset();
        if (xA == null || xA.length <= 1 || com.baidu.live.v.a.zs().axR == null) {
            z = false;
        } else {
            aj ajVar = com.baidu.live.v.a.zs().axR.adf;
            if (ajVar != null && ajVar.acF != null && !TextUtils.isEmpty(xA[0])) {
                if (TbadkCoreApplication.getInst().isMobileBaidu() && xA[0].equals("guard_seat_effect")) {
                    xA[0] = "";
                }
                JSONObject optJSONObject2 = ajVar.acF.optJSONObject(xA[0]);
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("transparency");
                    if (optInt >= 0 && optInt <= 100) {
                        cVar.abC = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                    } else {
                        cVar.abC = 255;
                    }
                    cVar.abD = optJSONObject2.optString("tail_icon");
                    String optString3 = optJSONObject2.optString("start_color");
                    String optString4 = optJSONObject2.optString("end_color");
                    try {
                        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                            cVar.aby = Color.parseColor(optString3);
                            cVar.abz = Color.parseColor(optString4);
                            z2 = true;
                        } else {
                            String optString5 = optJSONObject2.optString("bg_color");
                            if (!TextUtils.isEmpty(optString5)) {
                                cVar.aby = Color.parseColor(optString5);
                                cVar.abz = cVar.aby;
                                z2 = true;
                            }
                        }
                        if (z2) {
                            String optString6 = optJSONObject2.optString("frame_start_color");
                            String optString7 = optJSONObject2.optString("frame_end_color");
                            if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
                                cVar.abA = Color.parseColor(optString6);
                                cVar.abB = Color.parseColor(optString7);
                            }
                        }
                        z = z2;
                    } catch (Exception e) {
                        z = false;
                        e.printStackTrace();
                    }
                    if (ajVar != null && ajVar.acG != null && !TextUtils.isEmpty(xA[1]) && (optJSONObject = ajVar.acG.optJSONObject(xA[1])) != null) {
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
                            this.ath = Color.parseColor(optString);
                            this.ati = i2;
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
        this.atb.ato = false;
        this.atb.atp = false;
        if ("send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
            this.atb.ato = true;
            cVar.aby = Color.parseColor("#FFFF5D67");
            cVar.abz = cVar.aby;
            cVar.abC = 1;
        } else if ("guard_seat".equals(str)) {
            this.atb.atp = true;
        }
        this.atj = z3;
        cVar.arc = z;
        if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).aqM != null) {
            spannableStringBuilder = ((com.baidu.live.im.a) aVar).aqM;
        } else {
            SpannableStringBuilder a2 = a(aVar, cVar);
            SpannableStringBuilder a3 = a(aVar.xt());
            if (this.atf && a3 != null && a2 != null) {
                a2.insert(0, (CharSequence) a3);
            }
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).aqM = a2;
            }
            spannableStringBuilder = a2;
        }
        cVar.a(this.mContext, this.atb.atm, this.atb.isNormal, this.atb.ato, this.atb.atp);
        cVar.g(this.mContext, this.atb.atn);
        cVar.aqZ.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.aqZ.setMovementMethod(com.baidu.live.im.g.wt());
        if (this.ate) {
            cVar.aQ(true);
        }
        cVar.aqZ.setText(spannableStringBuilder);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        ata = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.atf = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.atf = true;
            String format = String.format(!z3 ? "%s " : "%s：", z ? this.mContext.getString(a.i.ala_host) : aVar.getNameShow());
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                spannableString.setSpan(new a(aVar, this.mGroupId, this.mLiveId, this.atc, this.atd), 0, length, 17);
            } else {
                C0088b c0088b = new C0088b(aVar, this.mGroupId, this.mLiveId, this.atc, this.atd);
                c0088b.atj = this.atj;
                c0088b.ath = this.ath;
                c0088b.ati = this.ati;
                spannableString.setSpan(c0088b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder a(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.Xv;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> D = D(list);
        if (ListUtils.isEmpty(D)) {
            return null;
        }
        String str = "  ";
        if (this.ate) {
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
                    com.baidu.live.view.c cVar = ALaImInitialize.ary.get(str3);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.ate, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.wS();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.ary.put(str3, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = ALaImInitialize.ary.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.ate, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.wS();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.ary.put(genCacheKey, cVar2);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.atd)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 5 ? linkedList.subList(0, 5) : linkedList;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wS() {
        long currentTimeMillis = System.currentTimeMillis() - this.atg;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.atg = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.atg = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.atc = z;
        this.atd = str3;
    }

    public boolean wT() {
        return this.atc;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0088b extends ClickableSpan implements c {
        private boolean YB;
        private String alO;
        private int ath;
        private int ati;
        private boolean atj;
        private com.baidu.live.data.a atl;
        private String groupId;
        private String liveId;

        C0088b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.atl = null;
            this.atl = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.YB = z;
            this.alO = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.ata) {
                if (this.atj) {
                    textPaint.setColor(this.ath);
                    textPaint.setAlpha(this.ati);
                } else {
                    textPaint.setColor(-1647769);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.ata) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.atl instanceof com.baidu.live.data.a) {
                str = this.atl.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.atl.userId, this.atl.userName, this.atl.portrait, this.atl.sex, this.atl.level_id, null, null, 0L, this.atl.Xp, this.atl.Xq, this.atl.Xr, this.groupId, this.liveId, this.YB, this.alO, str, this.atl.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void wY() {
            if (this.atl != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.atl.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.atl));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends ClickableSpan implements c {
        private boolean YB;
        private String alO;
        private com.baidu.live.data.a atl;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.atl = null;
            this.atl = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.YB = z;
            this.alO = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.ata) {
                textPaint.setColor(-1647769);
            } else if (2 == b.ata) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.atl instanceof com.baidu.live.data.a) {
                str = this.atl.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.atl.userId, this.atl.userName, this.atl.portrait, this.atl.sex, this.atl.level_id, null, null, 0L, this.atl.Xp, this.atl.Xq, this.atl.Xr, this.groupId, this.liveId, this.YB, this.alO, str, this.atl.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void wY() {
            if (this.atl != null) {
                if (this.atl.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.atl));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean wV() {
        return 2 != ata;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wW() {
        this.atb.atm = true;
        this.atb.atn = false;
        this.atb.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wX() {
        this.atb.atm = false;
        this.atb.atn = false;
        this.atb.isNormal = false;
    }

    public void aV(boolean z) {
        this.ate = z;
    }
}
