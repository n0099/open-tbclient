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
import com.baidu.live.data.ai;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.c;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.a, com.baidu.live.im.c> {
    protected static int apx = 1;
    private String apA;
    protected boolean apB;
    private boolean apC;
    private long apD;
    private int apE;
    private int apF;
    private boolean apG;
    protected d apy;
    private boolean apz;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    /* loaded from: classes2.dex */
    public interface c {
        void vp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class d {
        public boolean apJ = false;
        public boolean apK = true;
        public boolean isNormal = true;
        public boolean apL = false;
        public boolean apM = false;
    }

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    protected abstract void vl();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.apB = false;
        this.apC = false;
        this.apD = 0L;
        this.apy = new d();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: f */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == apx);
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
        this.apC = false;
        vl();
        String[] vx = aVar.vx();
        boolean z2 = false;
        boolean z3 = false;
        cVar.reset();
        if (vx == null || vx.length <= 1 || com.baidu.live.s.a.wR().atk == null) {
            z = false;
        } else {
            ai aiVar = com.baidu.live.s.a.wR().atk.aaW;
            if (aiVar != null && aiVar.aax != null && !TextUtils.isEmpty(vx[0])) {
                if (TbadkCoreApplication.getInst().isMobileBaidu() && vx[0].equals("guard_seat_effect")) {
                    vx[0] = "";
                }
                JSONObject optJSONObject2 = aiVar.aax.optJSONObject(vx[0]);
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("transparency");
                    if (optInt >= 0 && optInt <= 100) {
                        cVar.Zx = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                    } else {
                        cVar.Zx = 255;
                    }
                    cVar.Zy = optJSONObject2.optString("tail_icon");
                    String optString3 = optJSONObject2.optString("start_color");
                    String optString4 = optJSONObject2.optString("end_color");
                    try {
                        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                            cVar.Zt = Color.parseColor(optString3);
                            cVar.Zu = Color.parseColor(optString4);
                            z2 = true;
                        } else {
                            String optString5 = optJSONObject2.optString("bg_color");
                            if (!TextUtils.isEmpty(optString5)) {
                                cVar.Zt = Color.parseColor(optString5);
                                cVar.Zu = cVar.Zt;
                                z2 = true;
                            }
                        }
                        if (z2) {
                            String optString6 = optJSONObject2.optString("frame_start_color");
                            String optString7 = optJSONObject2.optString("frame_end_color");
                            if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
                                cVar.Zv = Color.parseColor(optString6);
                                cVar.Zw = Color.parseColor(optString7);
                            }
                        }
                        z = z2;
                    } catch (Exception e) {
                        z = false;
                        e.printStackTrace();
                    }
                    if (aiVar != null && aiVar.aay != null && !TextUtils.isEmpty(vx[1]) && (optJSONObject = aiVar.aay.optJSONObject(vx[1])) != null) {
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
                            this.apE = Color.parseColor(optString);
                            this.apF = i2;
                        }
                    }
                }
            }
            z = false;
            if (aiVar != null) {
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
        this.apy.apL = false;
        this.apy.apM = false;
        if ("send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
            this.apy.apL = true;
            cVar.Zt = Color.parseColor("#FFFF5D67");
            cVar.Zu = cVar.Zt;
            cVar.Zx = 1;
        } else if ("guard_seat".equals(str)) {
            this.apy.apM = true;
        }
        this.apG = z3;
        cVar.anz = z;
        if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).anj != null) {
            spannableStringBuilder = ((com.baidu.live.im.a) aVar).anj;
        } else {
            SpannableStringBuilder a2 = a(aVar, cVar);
            SpannableStringBuilder a3 = a(aVar.vq());
            if (this.apC && a3 != null && a2 != null) {
                a2.insert(0, (CharSequence) a3);
            }
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).anj = a2;
            }
            spannableStringBuilder = a2;
        }
        cVar.a(this.mContext, this.apy.apJ, this.apy.isNormal, this.apy.apL, this.apy.apM);
        cVar.g(this.mContext, this.apy.apK);
        cVar.anw.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.anw.setMovementMethod(com.baidu.live.im.g.uK());
        if (this.apB) {
            cVar.aN(true);
        }
        cVar.anw.setText(spannableStringBuilder);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        apx = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.apC = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.apC = true;
            String format = String.format(!z3 ? "%s " : "%s：", z ? this.mContext.getString(a.i.ala_host) : aVar.getNameShow());
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                spannableString.setSpan(new a(aVar, this.mGroupId, this.mLiveId, this.apz, this.apA), 0, length, 17);
            } else {
                C0081b c0081b = new C0081b(aVar, this.mGroupId, this.mLiveId, this.apz, this.apA);
                c0081b.apG = this.apG;
                c0081b.apE = this.apE;
                c0081b.apF = this.apF;
                spannableString.setSpan(c0081b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder a(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.VF;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> D = D(list);
        if (ListUtils.isEmpty(D)) {
            return null;
        }
        String str = "  ";
        if (this.apB) {
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
                    com.baidu.live.view.c cVar = ALaImInitialize.anV.get(str3);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.apB, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.vj();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.anV.put(str3, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = ALaImInitialize.anV.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.apB, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.vj();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.anV.put(genCacheKey, cVar2);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.apA)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 5 ? linkedList.subList(0, 5) : linkedList;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj() {
        long currentTimeMillis = System.currentTimeMillis() - this.apD;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.apD = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.apD = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.apz = z;
        this.apA = str3;
    }

    public boolean vk() {
        return this.apz;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0081b extends ClickableSpan implements c {
        private boolean WF;
        private String ajv;
        private int apE;
        private int apF;
        private boolean apG;
        private com.baidu.live.data.a apI;
        private String groupId;
        private String liveId;

        C0081b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.apI = null;
            this.apI = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.WF = z;
            this.ajv = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.apx) {
                if (this.apG) {
                    textPaint.setColor(this.apE);
                    textPaint.setAlpha(this.apF);
                } else {
                    textPaint.setColor(-1647769);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.apx) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.apI instanceof com.baidu.live.data.a) {
                str = this.apI.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.apI.userId, this.apI.userName, this.apI.portrait, this.apI.sex, this.apI.level_id, null, null, 0L, this.apI.Vz, this.apI.VA, this.apI.VB, this.groupId, this.liveId, this.WF, this.ajv, str, this.apI.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void vp() {
            if (this.apI != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.apI.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.apI));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends ClickableSpan implements c {
        private boolean WF;
        private String ajv;
        private com.baidu.live.data.a apI;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.apI = null;
            this.apI = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.WF = z;
            this.ajv = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.apx) {
                textPaint.setColor(-1647769);
            } else if (2 == b.apx) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.apI instanceof com.baidu.live.data.a) {
                str = this.apI.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.apI.userId, this.apI.userName, this.apI.portrait, this.apI.sex, this.apI.level_id, null, null, 0L, this.apI.Vz, this.apI.VA, this.apI.VB, this.groupId, this.liveId, this.WF, this.ajv, str, this.apI.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void vp() {
            if (this.apI != null) {
                if (this.apI.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.apI));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean vm() {
        return 2 != apx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vn() {
        this.apy.apJ = true;
        this.apy.apK = false;
        this.apy.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vo() {
        this.apy.apJ = false;
        this.apy.apK = false;
        this.apy.isNormal = false;
    }

    public void aS(boolean z) {
        this.apB = z;
    }
}
