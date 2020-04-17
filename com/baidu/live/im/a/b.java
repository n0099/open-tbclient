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
import com.baidu.live.data.am;
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
    protected static int aMo = 1;
    protected com.baidu.live.im.c.a aMp;
    protected boolean aMq;
    private String aMr;
    protected boolean aMs;
    private boolean aMt;
    private long aMu;
    private int aMv;
    private int aMw;
    private boolean aMx;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    /* loaded from: classes3.dex */
    public interface c {
        void BJ();
    }

    protected abstract void BF();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.aMs = false;
        this.aMt = false;
        this.aMu = 0L;
        this.aMp = new com.baidu.live.im.c.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: g */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == aMo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        String str;
        SpannableStringBuilder a2;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        int i2;
        this.aMt = false;
        BF();
        String[] Cm = aVar.Cm();
        boolean z = false;
        boolean z2 = false;
        cVar.reset();
        if (Cm != null && Cm.length > 1 && com.baidu.live.v.a.Eo().aRw != null) {
            am amVar = com.baidu.live.v.a.Eo().aRw.avw;
            if (amVar != null && amVar.auY != null && !TextUtils.isEmpty(Cm[0])) {
                if (TbadkCoreApplication.getInst().isMobileBaidu() && Cm[0].equals("guard_seat_effect")) {
                    Cm[0] = "";
                }
                JSONObject optJSONObject2 = amVar.auY.optJSONObject(Cm[0]);
                if (optJSONObject2 != null) {
                    int optInt = optJSONObject2.optInt("transparency");
                    if (optInt >= 0 && optInt <= 100) {
                        cVar.atW = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                    } else {
                        cVar.atW = 255;
                    }
                    cVar.aJI = !TextUtils.isEmpty(optJSONObject2.optString("tail_icon"));
                    String optString = optJSONObject2.optString("start_color");
                    String optString2 = optJSONObject2.optString("end_color");
                    try {
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            cVar.atS = Color.parseColor(optString);
                            cVar.atT = Color.parseColor(optString2);
                            z = true;
                        } else {
                            String optString3 = optJSONObject2.optString("bg_color");
                            if (!TextUtils.isEmpty(optString3)) {
                                cVar.atS = Color.parseColor(optString3);
                                cVar.atT = cVar.atS;
                                z = true;
                            }
                        }
                        if (z) {
                            String optString4 = optJSONObject2.optString("frame_start_color");
                            String optString5 = optJSONObject2.optString("frame_end_color");
                            if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                                cVar.atU = Color.parseColor(optString4);
                                cVar.atV = Color.parseColor(optString5);
                            }
                        }
                    } catch (Exception e) {
                        z = false;
                        e.printStackTrace();
                    }
                }
            }
            if (amVar != null && amVar.auZ != null && !TextUtils.isEmpty(Cm[1]) && (optJSONObject = amVar.auZ.optJSONObject(Cm[1])) != null) {
                String optString6 = optJSONObject.optString("bg_color");
                String optString7 = optJSONObject.optString("transparency");
                if (!TextUtils.isEmpty(optString7)) {
                    try {
                        i2 = (int) (((Integer.parseInt(optString7) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                        i2 = 255;
                    }
                } else {
                    i2 = 255;
                }
                if (!TextUtils.isEmpty(optString6)) {
                    z2 = true;
                    this.aMv = Color.parseColor(optString6);
                    this.aMw = i2;
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
        this.aMp.aNC = false;
        this.aMp.aND = false;
        this.aMp.aNE = false;
        this.aMp.aNF = false;
        if ("send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
            this.aMp.aNC = true;
        } else if ("guard_seat".equals(str)) {
            this.aMp.aND = true;
        } else if ("guard_club_join".equals(str)) {
            this.aMp.aNE = true;
        } else if ("haokan_buy_goods".equals(str)) {
            this.aMp.aNF = true;
        }
        this.aMx = z2;
        cVar.aJH = z;
        if ((aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).aJv != null) {
            a2 = ((com.baidu.live.im.a) aVar).aJv;
        } else {
            a2 = a(aVar, cVar);
            SpannableStringBuilder a3 = a(aVar.Cf());
            if (this.aMt && a3 != null && a2 != null) {
                a2.insert(0, (CharSequence) a3);
            }
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).aJv = a2;
            }
        }
        cVar.a(this.mContext, this.aMp);
        cVar.g(this.mContext, this.aMp.aNB);
        cVar.aJE.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.aJE.setMovementMethod(com.baidu.live.im.g.Bd());
        if (this.aMs) {
            cVar.bt(true);
        }
        cVar.aJE.setText(a2);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        aMo = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.aMt = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.aMt = true;
            String format = String.format(!z3 ? "%s " : "%s：", aVar.getNameShow());
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                spannableString.setSpan(new a(aVar, this.mGroupId, this.mLiveId, this.aMq, this.aMr), 0, length, 17);
            } else {
                C0114b c0114b = new C0114b(aVar, this.mGroupId, this.mLiveId, this.aMq, this.aMr);
                c0114b.aMx = this.aMx;
                c0114b.aMv = this.aMv;
                c0114b.aMw = this.aMw;
                spannableString.setSpan(c0114b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder a(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.apy;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> I = I(list);
        if (ListUtils.isEmpty(I)) {
            return null;
        }
        String str = "  ";
        if (this.aMs) {
            str = "  ";
        }
        int length = str.length();
        String str2 = "";
        for (int i = 0; i < I.size(); i++) {
            str2 = str + str2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= I.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = I.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = i4 + 1;
                if (1 == alaLiveMarkData.type) {
                    String str3 = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + aVar.level_id;
                    com.baidu.live.view.c cVar = ALaImInitialize.aKv.get(str3);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.aMs, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.BD();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.aKv.put(str3, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = ALaImInitialize.aKv.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.aMs, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.BD();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        ALaImInitialize.aKv.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> I(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aMr)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 5 ? linkedList.subList(0, 5) : linkedList;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BD() {
        long currentTimeMillis = System.currentTimeMillis() - this.aMu;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.aMu = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.aMu = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void a(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.aMq = z;
        this.aMr = str3;
    }

    public boolean BE() {
        return this.aMq;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0114b extends ClickableSpan implements c {
        private String aEe;
        private int aMv;
        private int aMw;
        private boolean aMx;
        private com.baidu.live.data.a aMz;
        private boolean aqL;
        private String groupId;
        private String liveId;

        C0114b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.aMz = null;
            this.aMz = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aqL = z;
            this.aEe = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.aMo) {
                if (this.aMx) {
                    textPaint.setColor(this.aMv);
                    textPaint.setAlpha(this.aMw);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.aMo) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.aMz instanceof com.baidu.live.data.a) {
                str = this.aMz.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.aMz.userId, this.aMz.userName, this.aMz.portrait, this.aMz.sex, this.aMz.level_id, null, null, 0L, this.aMz.aps, this.aMz.apt, this.aMz.apu, this.groupId, this.liveId, this.aqL, this.aEe, str, this.aMz.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void BJ() {
            if (this.aMz != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.aMz.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aMz));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends ClickableSpan implements c {
        private String aEe;
        private com.baidu.live.data.a aMz;
        private boolean aqL;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.aMz = null;
            this.aMz = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aqL = z;
            this.aEe = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.aMo) {
                textPaint.setColor(-5462);
            } else if (2 == b.aMo) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.aMz instanceof com.baidu.live.data.a) {
                str = this.aMz.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.aMz.userId, this.aMz.userName, this.aMz.portrait, this.aMz.sex, this.aMz.level_id, null, null, 0L, this.aMz.aps, this.aMz.apt, this.aMz.apu, this.groupId, this.liveId, this.aqL, this.aEe, str, this.aMz.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.a.b.c
        public void BJ() {
            if (this.aMz != null) {
                if (this.aMz.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aMz));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BG() {
        return 2 != aMo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BH() {
        this.aMp.aNA = true;
        this.aMp.aNB = false;
        this.aMp.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BI() {
        this.aMp.aNA = false;
        this.aMp.aNB = false;
        this.aMp.isNormal = false;
    }

    public void bx(boolean z) {
        this.aMs = z;
    }

    public void by(boolean z) {
        this.aMt = z;
    }
}
