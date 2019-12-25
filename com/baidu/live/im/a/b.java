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
import com.baidu.live.data.ae;
import com.baidu.live.im.ALaImInitialize;
import com.baidu.live.q.a;
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
    protected static int aoK = 1;
    protected d aoL;
    private boolean aoM;
    private String aoN;
    protected boolean aoO;
    private boolean aoP;
    private long aoQ;
    private int aoR;
    private int aoS;
    private boolean aoT;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    /* loaded from: classes2.dex */
    public interface c {
        void uY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class d {
        public boolean aoW = false;
        public boolean aoX = true;
        public boolean isNormal = true;
        public boolean aoY = false;
        public boolean aoZ = false;
    }

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    protected abstract void uU();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aoO = false;
        this.aoP = false;
        this.aoQ = 0L;
        this.aoL = new d();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: f */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == aoK);
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
        this.aoP = false;
        uU();
        String[] vg = aVar.vg();
        boolean z2 = false;
        boolean z3 = false;
        cVar.reset();
        if (vg == null || vg.length <= 1 || com.baidu.live.r.a.wA().asy == null) {
            z = false;
        } else {
            ae aeVar = com.baidu.live.r.a.wA().asy.aaJ;
            if (aeVar != null && aeVar.aak != null && !TextUtils.isEmpty(vg[0])) {
                if (TbadkCoreApplication.getInst().isMobileBaidu() && vg[0].equals("guard_seat_effect")) {
                    vg[0] = "";
                }
                JSONObject optJSONObject2 = aeVar.aak.optJSONObject(vg[0]);
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("transparency");
                    if (optInt >= 0 && optInt <= 100) {
                        cVar.Zj = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                    } else {
                        cVar.Zj = 255;
                    }
                    cVar.Zk = optJSONObject2.optString("tail_icon");
                    String optString3 = optJSONObject2.optString("start_color");
                    String optString4 = optJSONObject2.optString("end_color");
                    try {
                        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                            cVar.Zf = Color.parseColor(optString3);
                            cVar.Zg = Color.parseColor(optString4);
                            z2 = true;
                        } else {
                            String optString5 = optJSONObject2.optString("bg_color");
                            if (!TextUtils.isEmpty(optString5)) {
                                cVar.Zf = Color.parseColor(optString5);
                                cVar.Zg = cVar.Zf;
                                z2 = true;
                            }
                        }
                        if (z2) {
                            String optString6 = optJSONObject2.optString("frame_start_color");
                            String optString7 = optJSONObject2.optString("frame_end_color");
                            if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
                                cVar.Zh = Color.parseColor(optString6);
                                cVar.Zi = Color.parseColor(optString7);
                            }
                        }
                        z = z2;
                    } catch (Exception e) {
                        z = false;
                        e.printStackTrace();
                    }
                    if (aeVar != null && aeVar.aal != null && !TextUtils.isEmpty(vg[1]) && (optJSONObject = aeVar.aal.optJSONObject(vg[1])) != null) {
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
                            this.aoR = Color.parseColor(optString);
                            this.aoS = i2;
                        }
                    }
                }
            }
            z = false;
            if (aeVar != null) {
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
        this.aoL.aoY = false;
        this.aoL.aoZ = false;
        if ("send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
            this.aoL.aoY = true;
            cVar.Zf = Color.parseColor("#FFFF5D67");
            cVar.Zg = cVar.Zf;
            cVar.Zj = 1;
        } else if ("guard_seat".equals(str)) {
            this.aoL.aoZ = true;
        }
        this.aoT = z3;
        cVar.amM = z;
        if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).amw != null) {
            spannableStringBuilder = ((com.baidu.live.im.a) aVar).amw;
        } else {
            SpannableStringBuilder a2 = a(aVar, cVar);
            SpannableStringBuilder a3 = a(aVar.uZ());
            if (this.aoP && a3 != null && a2 != null) {
                a2.insert(0, (CharSequence) a3);
            }
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).amw = a2;
            }
            spannableStringBuilder = a2;
        }
        cVar.a(this.mContext, this.aoL.aoW, this.aoL.isNormal, this.aoL.aoY, this.aoL.aoZ);
        cVar.g(this.mContext, this.aoL.aoX);
        cVar.amJ.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.amJ.setMovementMethod(com.baidu.live.im.g.ut());
        if (this.aoO) {
            cVar.aL(true);
        }
        cVar.amJ.setText(spannableStringBuilder);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        aoK = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.aoP = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.aoP = true;
            String format = String.format(!z3 ? "%s " : "%s：", z ? this.mContext.getString(a.i.ala_host) : aVar.getNameShow());
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                spannableString.setSpan(new a(aVar, this.mGroupId, this.mLiveId, this.aoM, this.aoN), 0, length, 17);
            } else {
                C0083b c0083b = new C0083b(aVar, this.mGroupId, this.mLiveId, this.aoM, this.aoN);
                c0083b.aoT = this.aoT;
                c0083b.aoR = this.aoR;
                c0083b.aoS = this.aoS;
                spannableString.setSpan(c0083b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder a(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.Vp;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> E = E(list);
        if (ListUtils.isEmpty(E)) {
            return null;
        }
        String str = "  ";
        if (this.aoO) {
            str = "  ";
        }
        int length = str.length();
        String str2 = "";
        for (int i = 0; i < E.size(); i++) {
            str2 = str + str2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= E.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = E.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = i4 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str3 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + aVar.level_id;
                    com.baidu.live.view.c cVar = ALaImInitialize.ani.get(str3);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.aoO, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.uS();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.ani.put(str3, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = ALaImInitialize.ani.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.aoO, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void e(Bitmap bitmap) {
                                b.this.uS();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.ani.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> E(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aoN)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 4 ? linkedList.subList(0, 4) : linkedList;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS() {
        long currentTimeMillis = System.currentTimeMillis() - this.aoQ;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.aoQ = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.aoQ = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aoM = z;
        this.aoN = str3;
    }

    public boolean uT() {
        return this.aoM;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0083b extends ClickableSpan implements c {
        private boolean Wm;
        private String aiK;
        private int aoR;
        private int aoS;
        private boolean aoT;
        private com.baidu.live.data.a aoV;
        private String groupId;
        private String liveId;

        C0083b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.aoV = null;
            this.aoV = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.Wm = z;
            this.aiK = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.aoK) {
                if (this.aoT) {
                    textPaint.setColor(this.aoR);
                    textPaint.setAlpha(this.aoS);
                } else {
                    textPaint.setColor(-1647769);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.aoK) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.aoV instanceof com.baidu.live.data.a) {
                str = this.aoV.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.aoV.userId, this.aoV.userName, this.aoV.portrait, this.aoV.sex, this.aoV.level_id, null, null, 0L, this.aoV.Vj, this.aoV.Vk, this.aoV.Vl, this.groupId, this.liveId, this.Wm, this.aiK, str, this.aoV.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void uY() {
            if (this.aoV != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.aoV.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aoV));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends ClickableSpan implements c {
        private boolean Wm;
        private String aiK;
        private com.baidu.live.data.a aoV;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.aoV = null;
            this.aoV = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.Wm = z;
            this.aiK = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.aoK) {
                textPaint.setColor(-1647769);
            } else if (2 == b.aoK) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.aoV instanceof com.baidu.live.data.a) {
                str = this.aoV.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.aoV.userId, this.aoV.userName, this.aoV.portrait, this.aoV.sex, this.aoV.level_id, null, null, 0L, this.aoV.Vj, this.aoV.Vk, this.aoV.Vl, this.groupId, this.liveId, this.Wm, this.aiK, str, this.aoV.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void uY() {
            if (this.aoV != null) {
                if (this.aoV.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aoV));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean uV() {
        return 2 != aoK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uW() {
        this.aoL.aoW = true;
        this.aoL.aoX = false;
        this.aoL.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uX() {
        this.aoL.aoW = false;
        this.aoL.aoX = false;
        this.aoL.isNormal = false;
    }

    public void aQ(boolean z) {
        this.aoO = z;
    }
}
