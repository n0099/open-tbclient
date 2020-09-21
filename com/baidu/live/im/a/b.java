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
import com.baidu.live.data.bd;
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
    protected static int beh = 1;
    private String aBm;
    protected com.baidu.live.im.e.a bei;
    protected boolean bej;
    protected boolean bek;
    private boolean bel;
    private long bem;
    private int ben;
    private int beo;
    private boolean bep;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void Kc();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bek = false;
        this.bel = false;
        this.bem = 0L;
        this.bei = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: o */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == beh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(30:1|(2:3|(25:5|6|7|(1:9)(1:100)|10|11|12|(1:96)(1:17)|18|(1:95)(2:22|(1:24)(2:86|(1:88)(2:89|(1:91)(2:92|(1:94)))))|25|(9:27|(1:84)(2:31|(1:(2:35|(1:37)(1:64)))(2:65|(1:83)))|(1:63)(1:43)|44|(4:55|(1:59)|60|(1:62))(1:48)|49|(1:51)|52|53)|85|(1:39)|63|44|(1:46)|55|(1:59)|60|(0)|49|(0)|52|53))|103|6|7|(0)(0)|10|11|12|(1:14)|96|18|(1:20)|95|25|(0)|85|(0)|63|44|(0)|55|(0)|60|(0)|49|(0)|52|53|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011d, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011e, code lost:
        r3 = null;
        r4 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0111 A[Catch: JSONException -> 0x011c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {JSONException -> 0x011c, blocks: (B:7:0x0022, B:9:0x002a, B:45:0x0111), top: B:105:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[Catch: JSONException -> 0x011c, TRY_LEAVE, TryCatch #1 {JSONException -> 0x011c, blocks: (B:7:0x0022, B:9:0x002a, B:45:0x0111), top: B:105:0x0022 }] */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar) {
        int i2;
        JSONObject jSONObject;
        String str;
        boolean a2;
        boolean z;
        SpannableStringBuilder a3;
        SpannableStringBuilder d;
        this.bel = false;
        Kc();
        cVar.reset();
        if (aVar.Ko() != null) {
            List<AlaLiveMarkData> list = aVar.Ko().aDE;
            if (!ListUtils.isEmpty(list)) {
                i2 = Q(list);
                if (!(aVar.getObjContent() instanceof JSONObject)) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                str = jSONObject.optString("content_type");
                JSONObject jSONObject2 = jSONObject;
                if (str == null && str.equals("activity_common_im") && jSONObject2 != null) {
                    a2 = a(jSONObject2.optJSONObject("content_data"), cVar);
                } else {
                    a2 = a(aVar, cVar, i2);
                }
                boolean a4 = a(aVar, i2);
                this.bei.bfw = false;
                this.bei.bfx = false;
                this.bei.bfy = false;
                this.bei.bfz = false;
                this.bei.bfA = false;
                if (!"send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
                    this.bei.bfw = true;
                } else if ("guard_seat".equals(str)) {
                    this.bei.bfx = true;
                } else if ("guard_club_join".equals(str)) {
                    this.bei.bfy = true;
                } else if ("haokan_buy_goods".equals(str)) {
                    this.bei.bfz = true;
                } else if ("privilege_award_royal_success".equals(str)) {
                    this.bei.bfA = true;
                }
                this.bep = a4;
                cVar.bbn = a2;
                if (!aVar.Kz()) {
                    if (aVar.getMsgType() == 1 || aVar.getMsgType() == 126) {
                        z = true;
                    } else if (aVar.getMsgType() == 24) {
                        if (str != null && jSONObject2 != null) {
                            z = !jSONObject2.optString("content_type").equals("pk_send_props");
                        }
                    } else if ((aVar.getMsgType() == 13 || aVar.getMsgType() == 27) && (TextUtils.equals(str, "enter_live") || TextUtils.equals(str, "follow_anchor") || TextUtils.equals(str, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str, "share_tieba") || TextUtils.equals(str, "share_rmb") || TextUtils.equals(str, "zan_rmb") || TextUtils.equals(str, "add_tags_to_anchor"))) {
                        z = true;
                    }
                    if (!z && aVar.Ko() != null && !TextUtils.isEmpty(aVar.Ko().portrait)) {
                        cVar.a(true, aVar.Ko().portrait, i2);
                        cVar.bbk.setOnClickListener(new c(aVar.Ko(), this.mGroupId, this.mLiveId, this.bej, this.aBm));
                    } else {
                        cVar.a(false, "", 0);
                        cVar.bbk.setOnClickListener(null);
                    }
                    if (!(aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).baW != null) {
                        a3 = ((com.baidu.live.im.a) aVar).baW;
                    } else {
                        a3 = a(aVar, cVar);
                        d = d(aVar.Ko());
                        if (this.bel && d != null && a3 != null) {
                            a3.insert(0, (CharSequence) d);
                        }
                        if (aVar instanceof com.baidu.live.im.a) {
                            ((com.baidu.live.im.a) aVar).baW = a3;
                        }
                    }
                    cVar.a(this.mContext, this.bei);
                    cVar.i(this.mContext, this.bei.bfv);
                    cVar.bbh.setHighlightColor(this.mContext.getResources().getColor(17170445));
                    cVar.bbh.setMovementMethod(com.baidu.live.im.g.JG());
                    if (this.bek) {
                        cVar.bN(true);
                    }
                    cVar.bbh.setText(a3);
                    return view;
                }
                z = false;
                if (!z) {
                }
                cVar.a(false, "", 0);
                cVar.bbk.setOnClickListener(null);
                if (!(aVar instanceof com.baidu.live.im.a)) {
                }
                a3 = a(aVar, cVar);
                d = d(aVar.Ko());
                if (this.bel) {
                    a3.insert(0, (CharSequence) d);
                }
                if (aVar instanceof com.baidu.live.im.a) {
                }
                cVar.a(this.mContext, this.bei);
                cVar.i(this.mContext, this.bei.bfv);
                cVar.bbh.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.bbh.setMovementMethod(com.baidu.live.im.g.JG());
                if (this.bek) {
                }
                cVar.bbh.setText(a3);
                return view;
            }
        }
        i2 = 0;
        if (!(aVar.getObjContent() instanceof JSONObject)) {
        }
        str = jSONObject.optString("content_type");
        JSONObject jSONObject22 = jSONObject;
        if (str == null) {
        }
        a2 = a(aVar, cVar, i2);
        boolean a42 = a(aVar, i2);
        this.bei.bfw = false;
        this.bei.bfx = false;
        this.bei.bfy = false;
        this.bei.bfz = false;
        this.bei.bfA = false;
        if (!"send_redpacket".equals(str)) {
        }
        this.bei.bfw = true;
        this.bep = a42;
        cVar.bbn = a2;
        if (!aVar.Kz()) {
        }
        z = false;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.bbk.setOnClickListener(null);
        if (!(aVar instanceof com.baidu.live.im.a)) {
        }
        a3 = a(aVar, cVar);
        d = d(aVar.Ko());
        if (this.bel) {
        }
        if (aVar instanceof com.baidu.live.im.a) {
        }
        cVar.a(this.mContext, this.bei);
        cVar.i(this.mContext, this.bei.bfv);
        cVar.bbh.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.bbh.setMovementMethod(com.baidu.live.im.g.JG());
        if (this.bek) {
        }
        cVar.bbh.setText(a3);
        return view;
    }

    protected boolean a(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z = true;
        String optString = jSONObject.optString("start_bg_color");
        String optString2 = jSONObject.optString("end_bg_color");
        double optDouble = jSONObject.optDouble("alpha");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            cVar.aJv = Color.parseColor(optString.trim());
            cVar.aJw = Color.parseColor(optString2.trim());
        } else {
            String optString3 = jSONObject.optString("bg_color");
            if (TextUtils.isEmpty(optString3)) {
                z = false;
            } else {
                cVar.aJv = Color.parseColor(optString3);
                cVar.aJw = cVar.aJv;
            }
        }
        if (optDouble >= 0.0d && optDouble <= 1.0d) {
            cVar.aJz = (int) (255.0d * optDouble);
        } else {
            cVar.aJz = 255;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar, int i) {
        JSONObject jSONObject;
        boolean z;
        bd bdVar;
        JSONObject jSONObject2 = null;
        String[] Kv = aVar.Kv();
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && (Kv == null || Kv.length == 0 || !TextUtils.equals(Kv[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.x.a.NN().bmW != null && (bdVar = com.baidu.live.x.a.NN().bmW.aKS) != null && bdVar.aKu != null && Kv != null && Kv.length > 0 && !TextUtils.isEmpty(Kv[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(Kv[0], "guard_seat_effect"))) {
            jSONObject2 = bdVar.aKu.optJSONObject(Kv[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                cVar.aJz = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                cVar.aJz = 255;
            }
            cVar.bbo = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aJv = Color.parseColor(optString);
                    cVar.aJw = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aJv = Color.parseColor(optString3);
                        cVar.aJw = cVar.aJv;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        cVar.aJx = Color.parseColor(optString4);
                        cVar.aJy = Color.parseColor(optString5);
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
        bd bdVar;
        int i2 = 255;
        String[] Kv = aVar.Kv();
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
        } else if (com.baidu.live.x.a.NN().bmW != null && (bdVar = com.baidu.live.x.a.NN().bmW.aKS) != null && bdVar.aKv != null && Kv != null && Kv.length > 1 && !TextUtils.isEmpty(Kv[1])) {
            jSONObject2 = bdVar.aKv.optJSONObject(Kv[1]);
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
                this.ben = Color.parseColor(optString2);
                this.beo = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        beh = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.bel = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bel = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.bej, this.aBm);
                aVar2.bep = this.bep;
                aVar2.ben = this.ben;
                aVar2.beo = this.beo;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0176b c0176b = new C0176b(aVar, this.mGroupId, this.mLiveId, this.bej, this.aBm);
                c0176b.bep = this.bep;
                c0176b.ben = this.ben;
                c0176b.beo = this.beo;
                spannableString.setSpan(c0176b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aDE;
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
                    com.baidu.live.view.c cVar = com.baidu.live.view.c.bwm.get(str);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.bek, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.Ka();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bwm.put(str, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = com.baidu.live.view.c.bwm.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.bek, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.Ka();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bwm.put(genCacheKey, cVar2);
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
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aBm)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int Q(List<AlaLiveMarkData> list) {
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
    public void Ka() {
        long currentTimeMillis = System.currentTimeMillis() - this.bem;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bem = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bem = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bej = z;
        this.aBm = str3;
    }

    public boolean Kb() {
        return this.bej;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0176b extends ClickableSpan implements g.a {
        private boolean aFD;
        private String aVl;
        private int ben;
        private int beo;
        private boolean bep;
        private com.baidu.live.data.a ber;
        private String groupId;
        private String liveId;

        C0176b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.ber = null;
            this.ber = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aFD = z;
            this.aVl = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.beh) {
                if (this.bep) {
                    textPaint.setColor(this.ben);
                    textPaint.setAlpha(this.beo);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.beh) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.ber instanceof com.baidu.live.data.a) {
                str = this.ber.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.ber.userId, this.ber.userName, this.ber.portrait, this.ber.sex, this.ber.level_id, null, null, 0L, this.ber.aDy, this.ber.aDz, this.ber.aDA, this.groupId, this.liveId, this.aFD, this.aVl, str, this.ber.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void JH() {
            if (this.ber != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.ber.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.ber));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aFD;
        private String aVl;
        private int ben;
        private int beo;
        private boolean bep;
        private com.baidu.live.data.a ber;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.ber = null;
            this.ber = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aFD = z;
            this.aVl = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.beh) {
                if (this.bep) {
                    textPaint.setColor(this.ben);
                    textPaint.setAlpha(this.beo);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.beh) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.ber instanceof com.baidu.live.data.a) {
                str = this.ber.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.ber.userId, this.ber.userName, this.ber.portrait, this.ber.sex, this.ber.level_id, null, null, 0L, this.ber.aDy, this.ber.aDz, this.ber.aDA, this.groupId, this.liveId, this.aFD, this.aVl, str, this.ber.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void JH() {
            if (this.ber != null) {
                if (this.ber.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.ber));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements View.OnClickListener {
        private boolean aFD;
        private String aVl;
        private com.baidu.live.data.a ber;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.ber = null;
            this.ber = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aFD = z;
            this.aVl = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.ber.userId, this.ber.userName, this.ber.portrait, this.ber.sex, this.ber.level_id, null, null, 0L, this.ber.aDy, this.ber.aDz, this.ber.aDA, this.groupId, this.liveId, this.aFD, this.aVl, this.ber.appId, this.ber.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Kd() {
        return 2 != beh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ke() {
        this.bei.bfu = true;
        this.bei.bfv = false;
        this.bei.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kf() {
        this.bei.bfu = false;
        this.bei.bfv = false;
        this.bei.isNormal = false;
    }

    public void bR(boolean z) {
        this.bek = z;
    }

    public void bS(boolean z) {
        this.bel = z;
    }
}
