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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
import com.baidu.live.data.bl;
import com.baidu.live.data.dd;
import com.baidu.live.data.x;
import com.baidu.live.im.g;
import com.baidu.live.message.ShowRoomCard;
import com.baidu.live.message.YuyinShowRoomDialogMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.view.b;
import com.baidu.tbadk.TbConfig;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b extends AbsDelegateAdapter<com.baidu.live.im.data.b, com.baidu.live.yuyinim.a> {
    protected static int boX = 1;
    private String aGB;
    protected boolean boZ;
    protected boolean bpb;
    private boolean bpc;
    private long bpd;
    private int bpe;
    private int bpf;
    private boolean bpg;
    protected com.baidu.live.yuyinim.b.b cdB;
    private Set<Integer> cdC;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void MW();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bpb = false;
        this.bpc = false;
        this.bpd = 0L;
        this.cdC = new HashSet();
        this.cdB = new com.baidu.live.yuyinim.b.b();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: A */
    public com.baidu.live.yuyinim.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.yuyinim.a(this.mContext, 2 == boX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(35:1|(2:3|(23:5|6|7|8|(1:10)(2:149|150)|11|12|13|(1:17)|18|(1:147)(2:22|(1:24)(2:123|(1:125)(2:126|(1:128)(2:129|(1:131)(2:132|(5:135|136|138|139|140))))))|25|(2:27|(1:68)(2:33|(1:67)))|(1:(1:122)(2:114|(2:117|118)))(1:74)|75|(5:102|(1:106)|107|(1:109)|110)(1:79)|80|(1:82)|83|(1:85)(1:101)|86|(1:100)(2:94|(1:96)(1:99))|97))|153|6|7|8|(0)(0)|11|12|13|(2:15|17)|18|(1:20)|147|25|(0)|(1:70)|(1:112)|122|75|(1:77)|102|(1:106)|107|(0)|110|80|(0)|83|(0)(0)|86|(1:88)|100|97|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0217, code lost:
        r3 = "";
        r9 = r6;
        r10 = r7;
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b A[Catch: JSONException -> 0x0216, TryCatch #3 {JSONException -> 0x0216, blocks: (B:8:0x0043, B:10:0x004b, B:11:0x0052, B:61:0x020a), top: B:153:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x020a A[Catch: JSONException -> 0x0216, TRY_ENTER, TRY_LEAVE, TryCatch #3 {JSONException -> 0x0216, blocks: (B:8:0x0043, B:10:0x004b, B:11:0x0052, B:61:0x020a), top: B:153:0x0043 }] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar) {
        int i2;
        String str;
        String str2;
        boolean z;
        SpannableStringBuilder a2;
        SpannableStringBuilder d;
        SpannableStringBuilder spannableStringBuilder;
        Exception e;
        String str3;
        String optString;
        this.bpc = false;
        MW();
        aVar.reset();
        if (bVar.Nw() != null) {
            List<AlaLiveMarkData> list = bVar.Nw().aIZ;
            if (!ListUtils.isEmpty(list)) {
                i2 = U(list);
                boolean a3 = a(bVar, aVar, i2);
                boolean a4 = a(bVar, i2);
                JSONObject jSONObject = null;
                String str4 = "";
                String str5 = "";
                String str6 = null;
                String str7 = null;
                if (!(bVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                String optString2 = jSONObject.optString("content_type");
                str4 = jSONObject.optString("text");
                str5 = jSONObject.optString(DpStatConstants.KEY_ROOM_NAME);
                str = jSONObject.optString("level_id");
                String str8 = str5;
                String str9 = str4;
                str2 = optString2;
                if (!TextUtils.isEmpty(str) && JavaTypesHelper.toInt(str, 0) > 0) {
                    bVar.Nw().level_id = JavaTypesHelper.toInt(str, 0);
                }
                this.cdB.brc = false;
                this.cdB.brd = false;
                this.cdB.bre = false;
                this.cdB.brf = false;
                this.cdB.brg = false;
                if (!"send_redpacket".equals(str2) || "start_grab_redpacket".equals(str2)) {
                    this.cdB.brc = true;
                } else if ("guard_seat".equals(str2)) {
                    this.cdB.brd = true;
                } else if ("guard_club_join".equals(str2)) {
                    this.cdB.bre = true;
                } else if ("haokan_buy_goods".equals(str2)) {
                    this.cdB.brf = true;
                } else if ("privilege_award_royal_success".equals(str2)) {
                    this.cdB.brg = true;
                } else if ("audio_emoticon".equals(str2) && jSONObject != null) {
                    try {
                        jSONObject.optJSONObject("emoticon_info").optString("compression_img");
                        optString = jSONObject.optJSONObject("emoticon_info").optString("prototype_img");
                    } catch (Exception e2) {
                        e = e2;
                        str3 = null;
                    }
                    try {
                        str7 = jSONObject.optJSONObject("emoticon_info").optString("result_img");
                        str6 = optString;
                    } catch (Exception e3) {
                        e = e3;
                        str3 = optString;
                        e.printStackTrace();
                        str6 = str3;
                        this.bpg = a4;
                        aVar.blP = a3;
                        z = false;
                        if (!bVar.NH()) {
                        }
                        if (!z) {
                        }
                        if (!z) {
                        }
                        aVar.a(false, "", 0);
                        aVar.cbK.setOnClickListener(null);
                        if (!(bVar instanceof com.baidu.live.im.a)) {
                        }
                        a2 = a(bVar, aVar);
                        d = d(bVar.Nw());
                        if (this.bpc) {
                        }
                        if (bVar instanceof com.baidu.live.im.a) {
                        }
                        spannableStringBuilder = a2;
                        aVar.a(this.mContext, this.cdB);
                        aVar.m(this.mContext, this.cdB.brb);
                        aVar.blJ.setHighlightColor(this.mContext.getResources().getColor(17170445));
                        aVar.blJ.setMovementMethod(com.baidu.live.im.g.Mx());
                        if (this.bpb) {
                        }
                        if (TextUtils.equals(str2, "play_rules")) {
                        }
                        if (!"audio_emoticon".equals(str2)) {
                        }
                        aVar.cdu.setVisibility(8);
                        return view;
                    }
                }
                this.bpg = a4;
                aVar.blP = a3;
                z = false;
                if (!bVar.NH()) {
                    if (bVar.getMsgType() == 24 || bVar.getMsgType() == 1 || bVar.getMsgType() == 126) {
                        z = true;
                    } else if ((bVar.getMsgType() == 13 || bVar.getMsgType() == 27) && (TextUtils.equals(str2, "follow_anchor") || TextUtils.equals(str2, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str2, "share_tieba") || TextUtils.equals(str2, "play_rules") || TextUtils.equals(str2, "enter_live") || TextUtils.equals(str2, "share_rmb") || TextUtils.equals(str2, "zan_rmb") || TextUtils.equals(str2, "audio_emoticon") || TextUtils.equals(str2, "follow_anchor_phone") || TextUtils.equals(str2, "audio_hat_level_toast") || TextUtils.equals(str2, "audio_hat_user_toast") || TextUtils.equals(str2, "follow_room") || TextUtils.equals(str2, "audio_link_toast") || TextUtils.equals(str2, "mode_change_stage") || TextUtils.equals(str2, "mode_add_time"))) {
                        z = true;
                    }
                }
                if (!z && bVar.Nw() != null && !TextUtils.isEmpty(bVar.Nw().portrait)) {
                    aVar.a(true, bVar.Nw().portrait, i2);
                    aVar.cbK.setOnClickListener(new c(bVar.Nw(), this.mGroupId, this.mLiveId, this.boZ, this.aGB));
                } else if (!z && TextUtils.equals(str2, "play_rules")) {
                    if (TextUtils.equals(str2, "play_rules") && jSONObject != null) {
                        try {
                            final String optString3 = jSONObject.optString("room_id");
                            final String optString4 = jSONObject.optString("live_id");
                            aVar.a(true, jSONObject.optString("cover"), i2);
                            aVar.cbK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.a.b.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    b.this.aZ(optString4, optString3);
                                }
                            });
                            aVar.cds.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.a.b.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    b.this.aZ(optString4, optString3);
                                }
                            });
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } else {
                    aVar.a(false, "", 0);
                    aVar.cbK.setOnClickListener(null);
                }
                if (!(bVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) bVar).bly != null) {
                    spannableStringBuilder = ((com.baidu.live.im.a) bVar).bly;
                } else {
                    a2 = a(bVar, aVar);
                    d = d(bVar.Nw());
                    if (this.bpc && d != null && a2 != null) {
                        a2.insert(0, (CharSequence) d);
                    }
                    if (bVar instanceof com.baidu.live.im.a) {
                        ((com.baidu.live.im.a) bVar).bly = a2;
                    }
                    spannableStringBuilder = a2;
                }
                aVar.a(this.mContext, this.cdB);
                aVar.m(this.mContext, this.cdB.brb);
                aVar.blJ.setHighlightColor(this.mContext.getResources().getColor(17170445));
                aVar.blJ.setMovementMethod(com.baidu.live.im.g.Mx());
                if (this.bpb) {
                    aVar.ce(true);
                }
                if (TextUtils.equals(str2, "play_rules")) {
                    aVar.cds.setText(str8 + "：");
                    aVar.cds.setVisibility(0);
                    aVar.blJ.setText(str9);
                    aVar.blJ.setTextColor(Color.parseColor("#9BAEFD"));
                } else {
                    aVar.cds.setVisibility(8);
                    aVar.blJ.setText(spannableStringBuilder);
                }
                if (!"audio_emoticon".equals(str2) && !StringUtils.isNull(str6, true) && bVar.getMsgType() == 13 && !StringUtils.isNull(str7, true)) {
                    aVar.cdu.setVisibility(0);
                    if (this.cdC.contains(Integer.valueOf(i))) {
                        aVar.cdu.aL(null, str7);
                    } else {
                        this.cdC.add(Integer.valueOf(i));
                        aVar.cdu.aL(str6, str7);
                    }
                } else {
                    aVar.cdu.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        boolean a32 = a(bVar, aVar, i2);
        boolean a42 = a(bVar, i2);
        JSONObject jSONObject2 = null;
        String str42 = "";
        String str52 = "";
        String str62 = null;
        String str72 = null;
        if (!(bVar.getObjContent() instanceof JSONObject)) {
        }
        String optString22 = jSONObject2.optString("content_type");
        str42 = jSONObject2.optString("text");
        str52 = jSONObject2.optString(DpStatConstants.KEY_ROOM_NAME);
        str = jSONObject2.optString("level_id");
        String str82 = str52;
        String str92 = str42;
        str2 = optString22;
        if (!TextUtils.isEmpty(str)) {
            bVar.Nw().level_id = JavaTypesHelper.toInt(str, 0);
        }
        this.cdB.brc = false;
        this.cdB.brd = false;
        this.cdB.bre = false;
        this.cdB.brf = false;
        this.cdB.brg = false;
        if (!"send_redpacket".equals(str2)) {
        }
        this.cdB.brc = true;
        this.bpg = a42;
        aVar.blP = a32;
        z = false;
        if (!bVar.NH()) {
        }
        if (!z) {
        }
        if (!z) {
        }
        aVar.a(false, "", 0);
        aVar.cbK.setOnClickListener(null);
        if (!(bVar instanceof com.baidu.live.im.a)) {
        }
        a2 = a(bVar, aVar);
        d = d(bVar.Nw());
        if (this.bpc) {
            a2.insert(0, (CharSequence) d);
        }
        if (bVar instanceof com.baidu.live.im.a) {
        }
        spannableStringBuilder = a2;
        aVar.a(this.mContext, this.cdB);
        aVar.m(this.mContext, this.cdB.brb);
        aVar.blJ.setHighlightColor(this.mContext.getResources().getColor(17170445));
        aVar.blJ.setMovementMethod(com.baidu.live.im.g.Mx());
        if (this.bpb) {
        }
        if (TextUtils.equals(str2, "play_rules")) {
        }
        if (!"audio_emoticon".equals(str2)) {
        }
        aVar.cdu.setVisibility(8);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(String str, String str2) {
        x xVar = new x();
        xVar.aLl = new dd();
        xVar.aLl.live_id = str;
        xVar.aLl.aVu = str2;
        MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar)));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.b bVar, com.baidu.live.yuyinim.a aVar, int i) {
        JSONObject jSONObject;
        boolean z;
        bl blVar;
        JSONObject jSONObject2 = null;
        String[] ND = bVar.ND();
        if ((bVar.getMsgType() == 1 || bVar.getMsgType() == 126) && (ND == null || ND.length == 0 || !TextUtils.equals(ND[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.af.a.SE().bCb != null && (blVar = com.baidu.live.af.a.SE().bCb.aRD) != null && blVar.aRk != null && ND != null && ND.length > 0 && !TextUtils.isEmpty(ND[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(ND[0], "guard_seat_effect"))) {
            jSONObject2 = blVar.aRk.optJSONObject(ND[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                aVar.aQp = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                aVar.aQp = 255;
            }
            aVar.blQ = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    aVar.aQl = Color.parseColor(optString);
                    aVar.aQm = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        aVar.aQl = Color.parseColor(optString3);
                        aVar.aQm = aVar.aQl;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        aVar.aQn = Color.parseColor(optString4);
                        aVar.aQo = Color.parseColor(optString5);
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
        bl blVar;
        int i2 = 255;
        String[] ND = bVar.ND();
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
        } else if (com.baidu.live.af.a.SE().bCb != null && (blVar = com.baidu.live.af.a.SE().bCb.aRD) != null && blVar.aRl != null && ND != null && ND.length > 1 && !TextUtils.isEmpty(ND[1])) {
            jSONObject2 = blVar.aRl.optJSONObject(ND[1]);
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
                this.bpe = Color.parseColor(optString2);
                this.bpf = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        boX = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, String str) {
        this.bpc = true;
        a(spannableStringBuilder, aVar, aVar2, false, false, true, null, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2) {
        this.bpc = true;
        a(spannableStringBuilder, aVar, aVar2, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, aVar2, z, z2, z3, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.yuyinim.a aVar2, boolean z, boolean z2, boolean z3, String str, String str2) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bpc = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar3 = new a(aVar, this.mGroupId, this.mLiveId, this.boZ, this.aGB);
                aVar3.bpg = this.bpg;
                aVar3.bpe = this.bpe;
                aVar3.bpf = this.bpf;
                spannableString.setSpan(aVar3, 0, length, 17);
            } else {
                C0248b c0248b = new C0248b(aVar, this.mGroupId, this.mLiveId, this.boZ, this.aGB);
                c0248b.bpg = this.bpg;
                c0248b.bpe = this.bpe;
                c0248b.bpf = this.bpf;
                spannableString.setSpan(c0248b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            if (!TextUtils.isEmpty(str2)) {
                AlaLiveMarkData alaLiveMarkData = new AlaLiveMarkData();
                alaLiveMarkData.mark_pic = str2;
                alaLiveMarkData.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, false, new b.a() { // from class: com.baidu.live.yuyinim.a.b.3
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        b.this.MU();
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        int i = 0;
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aIZ;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> w = w(list);
        if (ListUtils.isEmpty(w)) {
            return null;
        }
        int length = "[img] ".length();
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < w.size(); i2++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        while (true) {
            int i3 = i;
            if (i3 >= w.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = w.get(i3);
            if (alaLiveMarkData != null) {
                alaLiveMarkData.userLevel = aVar.level_id;
                alaLiveMarkData.setupNewLevelMark();
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                com.baidu.live.view.b bVar = com.baidu.live.view.b.bTR.get(genCacheKey);
                if (bVar == null) {
                    bVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, this.bpb, new b.a() { // from class: com.baidu.live.yuyinim.a.b.4
                        @Override // com.baidu.live.view.b.a
                        public void e(Bitmap bitmap) {
                            b.this.MU();
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                        }
                    });
                    com.baidu.live.view.b.bTR.put(genCacheKey, bVar);
                }
                spannableStringBuilder.setSpan(bVar, i4, i5, 17);
            }
            i = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> w(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aGB)) {
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
    public void MU() {
        long currentTimeMillis = System.currentTimeMillis() - this.bpd;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bpd = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.a.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bpd = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.boZ = z;
        this.aGB = str3;
    }

    public boolean MV() {
        return this.boZ;
    }

    /* renamed from: com.baidu.live.yuyinim.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0248b extends ClickableSpan implements g.a {
        private boolean aLL;
        private String beG;
        private int bpe;
        private int bpf;
        private boolean bpg;
        private com.baidu.live.data.a bpi;
        private String groupId;
        private String liveId;

        C0248b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpi = null;
            this.bpi = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLL = z;
            this.beG = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.boX) {
                if (this.bpg) {
                    textPaint.setColor(this.bpe);
                    textPaint.setAlpha(this.bpf);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.boX) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bpi instanceof com.baidu.live.data.a) {
                str = this.bpi.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bpi.userId, this.bpi.userName, this.bpi.portrait, this.bpi.sex, this.bpi.level_id, null, null, 0L, this.bpi.aIT, this.bpi.aIU, this.bpi.aIV, this.groupId, this.liveId, this.aLL, this.beG, str, this.bpi.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void My() {
            if (this.bpi != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bpi.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bpi));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aLL;
        private String beG;
        private int bpe;
        private int bpf;
        private boolean bpg;
        private com.baidu.live.data.a bpi;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpi = null;
            this.bpi = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLL = z;
            this.beG = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.boX) {
                if (this.bpg) {
                    textPaint.setColor(this.bpe);
                    textPaint.setAlpha(this.bpf);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.boX) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bpi instanceof com.baidu.live.data.a) {
                str = this.bpi.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bpi.userId, this.bpi.userName, this.bpi.portrait, this.bpi.sex, this.bpi.level_id, null, null, 0L, this.bpi.aIT, this.bpi.aIU, this.bpi.aIV, this.groupId, this.liveId, this.aLL, this.beG, str, this.bpi.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void My() {
            if (this.bpi != null) {
                if (this.bpi.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.h.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bpi));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c implements View.OnClickListener {
        private boolean aLL;
        private String beG;
        private com.baidu.live.data.a bpi;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bpi = null;
            this.bpi = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aLL = z;
            this.beG = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(view.getContext(), this.bpi.userId, this.bpi.userName, this.bpi.portrait, this.bpi.sex, this.bpi.level_id, null, null, 0L, this.bpi.aIT, this.bpi.aIU, this.bpi.aIV, this.groupId, this.liveId, this.aLL, this.beG, this.bpi.appId, this.bpi.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean MX() {
        return 2 != boX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MY() {
        this.cdB.bra = true;
        this.cdB.brb = false;
        this.cdB.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MZ() {
        this.cdB.bra = false;
        this.cdB.brb = false;
        this.cdB.isNormal = false;
    }

    public void ci(boolean z) {
        this.bpb = z;
    }

    public void cj(boolean z) {
        this.bpc = z;
    }
}
