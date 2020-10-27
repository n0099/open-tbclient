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
import com.baidu.live.data.bg;
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
    protected static int bjp = 1;
    private String aEz;
    protected com.baidu.live.im.e.a bjq;
    protected boolean bjr;
    protected boolean bjs;
    private boolean bjt;
    private long bju;
    private int bjv;
    private int bjw;
    private boolean bjx;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;

    protected abstract void LB();

    protected abstract SpannableStringBuilder a(com.baidu.live.im.data.a aVar, com.baidu.live.im.c cVar);

    protected abstract int getColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.bjs = false;
        this.bjt = false;
        this.bju = 0L;
        this.bjq = new com.baidu.live.im.e.a();
        this.mHandler = new Handler();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: o */
    public com.baidu.live.im.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.live.im.c(this.mContext, 2 == bjp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(30:1|(2:3|(25:5|6|7|(1:9)(1:102)|10|11|12|(1:98)(1:17)|18|(1:97)(2:22|(1:24)(2:88|(1:90)(2:91|(1:93)(2:94|(1:96)))))|25|(9:27|(1:86)(2:31|(1:(2:35|(1:37)(1:64)))(2:65|(1:85)))|(1:63)(1:43)|44|(4:55|(1:59)|60|(1:62))(1:48)|49|(1:51)|52|53)|87|(1:39)|63|44|(1:46)|55|(1:59)|60|(0)|49|(0)|52|53))|105|6|7|(0)(0)|10|11|12|(1:14)|98|18|(1:20)|97|25|(0)|87|(0)|63|44|(0)|55|(0)|60|(0)|49|(0)|52|53|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011d, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011e, code lost:
        r3 = null;
        r4 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0111 A[Catch: JSONException -> 0x011c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x011c, blocks: (B:7:0x0022, B:9:0x002a, B:45:0x0111), top: B:105:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fe A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[Catch: JSONException -> 0x011c, TRY_LEAVE, TryCatch #0 {JSONException -> 0x011c, blocks: (B:7:0x0022, B:9:0x002a, B:45:0x0111), top: B:105:0x0022 }] */
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
        this.bjt = false;
        LB();
        cVar.reset();
        if (aVar.LO() != null) {
            List<AlaLiveMarkData> list = aVar.LO().aGQ;
            if (!ListUtils.isEmpty(list)) {
                i2 = T(list);
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
                this.bjq.bkC = false;
                this.bjq.bkD = false;
                this.bjq.bkE = false;
                this.bjq.bkF = false;
                this.bjq.bkG = false;
                if (!"send_redpacket".equals(str) || "start_grab_redpacket".equals(str)) {
                    this.bjq.bkC = true;
                } else if ("guard_seat".equals(str)) {
                    this.bjq.bkD = true;
                } else if ("guard_club_join".equals(str)) {
                    this.bjq.bkE = true;
                } else if ("haokan_buy_goods".equals(str)) {
                    this.bjq.bkF = true;
                } else if ("privilege_award_royal_success".equals(str)) {
                    this.bjq.bkG = true;
                }
                this.bjx = a4;
                cVar.bgn = a2;
                if (!aVar.LZ()) {
                    if (aVar.getMsgType() == 1 || aVar.getMsgType() == 126) {
                        z = true;
                    } else if (aVar.getMsgType() == 24) {
                        if (str != null && jSONObject2 != null) {
                            z = !jSONObject2.optString("content_type").equals("pk_send_props");
                        }
                    } else if ((aVar.getMsgType() == 13 || aVar.getMsgType() == 27) && (TextUtils.equals(str, "enter_live") || TextUtils.equals(str, "follow_anchor") || TextUtils.equals(str, TbConfig.TMP_SHARE_DIR_NAME) || TextUtils.equals(str, "share_tieba") || TextUtils.equals(str, "share_rmb") || TextUtils.equals(str, "zan_rmb") || TextUtils.equals(str, "tying_gift") || TextUtils.equals(str, "add_tags_to_anchor"))) {
                        z = true;
                    }
                    if (!z && aVar.LO() != null && !TextUtils.isEmpty(aVar.LO().portrait)) {
                        cVar.a(true, aVar.LO().portrait, i2);
                        cVar.bgk.setOnClickListener(new c(aVar.LO(), this.mGroupId, this.mLiveId, this.bjr, this.aEz));
                    } else {
                        cVar.a(false, "", 0);
                        cVar.bgk.setOnClickListener(null);
                    }
                    if (!(aVar instanceof com.baidu.live.im.a) && ((com.baidu.live.im.a) aVar).bfW != null) {
                        a3 = ((com.baidu.live.im.a) aVar).bfW;
                    } else {
                        a3 = a(aVar, cVar);
                        d = d(aVar.LO());
                        if (this.bjt && d != null && a3 != null) {
                            a3.insert(0, (CharSequence) d);
                        }
                        if (aVar instanceof com.baidu.live.im.a) {
                            ((com.baidu.live.im.a) aVar).bfW = a3;
                        }
                    }
                    cVar.a(this.mContext, this.bjq);
                    cVar.i(this.mContext, this.bjq.bkB);
                    cVar.bgh.setHighlightColor(this.mContext.getResources().getColor(17170445));
                    cVar.bgh.setMovementMethod(com.baidu.live.im.g.Lg());
                    if (this.bjs) {
                        cVar.bS(true);
                    }
                    cVar.bgh.setText(a3);
                    return view;
                }
                z = false;
                if (!z) {
                }
                cVar.a(false, "", 0);
                cVar.bgk.setOnClickListener(null);
                if (!(aVar instanceof com.baidu.live.im.a)) {
                }
                a3 = a(aVar, cVar);
                d = d(aVar.LO());
                if (this.bjt) {
                    a3.insert(0, (CharSequence) d);
                }
                if (aVar instanceof com.baidu.live.im.a) {
                }
                cVar.a(this.mContext, this.bjq);
                cVar.i(this.mContext, this.bjq.bkB);
                cVar.bgh.setHighlightColor(this.mContext.getResources().getColor(17170445));
                cVar.bgh.setMovementMethod(com.baidu.live.im.g.Lg());
                if (this.bjs) {
                }
                cVar.bgh.setText(a3);
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
        this.bjq.bkC = false;
        this.bjq.bkD = false;
        this.bjq.bkE = false;
        this.bjq.bkF = false;
        this.bjq.bkG = false;
        if (!"send_redpacket".equals(str)) {
        }
        this.bjq.bkC = true;
        this.bjx = a42;
        cVar.bgn = a2;
        if (!aVar.LZ()) {
        }
        z = false;
        if (!z) {
        }
        cVar.a(false, "", 0);
        cVar.bgk.setOnClickListener(null);
        if (!(aVar instanceof com.baidu.live.im.a)) {
        }
        a3 = a(aVar, cVar);
        d = d(aVar.LO());
        if (this.bjt) {
        }
        if (aVar instanceof com.baidu.live.im.a) {
        }
        cVar.a(this.mContext, this.bjq);
        cVar.i(this.mContext, this.bjq.bkB);
        cVar.bgh.setHighlightColor(this.mContext.getResources().getColor(17170445));
        cVar.bgh.setMovementMethod(com.baidu.live.im.g.Lg());
        if (this.bjs) {
        }
        cVar.bgh.setText(a3);
        return view;
    }

    protected boolean a(JSONObject jSONObject, com.baidu.live.im.c cVar) {
        boolean z = true;
        String optString = jSONObject.optString("start_bg_color");
        String optString2 = jSONObject.optString("end_bg_color");
        double optDouble = jSONObject.optDouble("alpha");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            cVar.aNf = Color.parseColor(optString.trim());
            cVar.aNg = Color.parseColor(optString2.trim());
        } else {
            String optString3 = jSONObject.optString("bg_color");
            if (TextUtils.isEmpty(optString3)) {
                z = false;
            } else {
                cVar.aNf = Color.parseColor(optString3);
                cVar.aNg = cVar.aNf;
            }
        }
        if (optDouble >= 0.0d && optDouble <= 1.0d) {
            cVar.aNj = (int) (255.0d * optDouble);
        } else {
            cVar.aNj = 255;
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
        bg bgVar;
        JSONObject jSONObject2 = null;
        String[] LV = aVar.LV();
        if ((aVar.getMsgType() == 1 || aVar.getMsgType() == 126) && (LV == null || LV.length == 0 || !TextUtils.equals(LV[0], "guard_seat_effect")) && i >= 5) {
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
        } else if (com.baidu.live.z.a.Pq().bsy != null && (bgVar = com.baidu.live.z.a.Pq().bsy.aOC) != null && bgVar.aOe != null && LV != null && LV.length > 0 && !TextUtils.isEmpty(LV[0]) && (!TbadkCoreApplication.getInst().isMobileBaidu() || !TextUtils.equals(LV[0], "guard_seat_effect"))) {
            jSONObject2 = bgVar.aOe.optJSONObject(LV[0]);
        }
        if (jSONObject2 == null) {
            int optInt = jSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                cVar.aNj = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                cVar.aNj = 255;
            }
            cVar.bgo = !TextUtils.isEmpty(jSONObject2.optString("tail_icon"));
            String optString = jSONObject2.optString("start_color");
            String optString2 = jSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    cVar.aNf = Color.parseColor(optString);
                    cVar.aNg = Color.parseColor(optString2);
                    z = true;
                } else {
                    String optString3 = jSONObject2.optString("bg_color");
                    if (TextUtils.isEmpty(optString3)) {
                        z = false;
                    } else {
                        cVar.aNf = Color.parseColor(optString3);
                        cVar.aNg = cVar.aNf;
                        z = true;
                    }
                }
                if (z) {
                    String optString4 = jSONObject2.optString("frame_start_color");
                    String optString5 = jSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                        cVar.aNh = Color.parseColor(optString4);
                        cVar.aNi = Color.parseColor(optString5);
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
        bg bgVar;
        int i2 = 255;
        String[] LV = aVar.LV();
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
        } else if (com.baidu.live.z.a.Pq().bsy != null && (bgVar = com.baidu.live.z.a.Pq().bsy.aOC) != null && bgVar.aOf != null && LV != null && LV.length > 1 && !TextUtils.isEmpty(LV[1])) {
            jSONObject2 = bgVar.aOf.optJSONObject(LV[1]);
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
                this.bjv = Color.parseColor(optString2);
                this.bjw = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMode(boolean z) {
        bjp = z ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2) {
        this.bjt = true;
        a(spannableStringBuilder, aVar, cVar, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3) {
        a(spannableStringBuilder, aVar, cVar, z, z2, z3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SpannableStringBuilder spannableStringBuilder, com.baidu.live.data.a aVar, com.baidu.live.im.c cVar, boolean z, boolean z2, boolean z3, String str) {
        if (spannableStringBuilder != null && aVar != null && !TextUtils.isEmpty(aVar.getNameShow())) {
            this.bjt = true;
            String nameShow = aVar.getNameShow();
            String format = String.format(!z3 ? "%s " : "%s：", !StringUtils.isNull(str) ? nameShow + str : nameShow);
            SpannableString spannableString = new SpannableString(format);
            int length = format.length();
            if (z) {
                a aVar2 = new a(aVar, this.mGroupId, this.mLiveId, this.bjr, this.aEz);
                aVar2.bjx = this.bjx;
                aVar2.bjv = this.bjv;
                aVar2.bjw = this.bjw;
                spannableString.setSpan(aVar2, 0, length, 17);
            } else {
                C0185b c0185b = new C0185b(aVar, this.mGroupId, this.mLiveId, this.bjr, this.aEz);
                c0185b.bjx = this.bjx;
                c0185b.bjv = this.bjv;
                c0185b.bjw = this.bjw;
                spannableString.setSpan(c0185b, 0, length, 17);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
    }

    private SpannableStringBuilder d(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            return null;
        }
        List<AlaLiveMarkData> list = aVar.aGQ;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        List<AlaLiveMarkData> v = v(list);
        if (ListUtils.isEmpty(v)) {
            return null;
        }
        int length = "[img] ".length();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < v.size(); i++) {
            sb = sb.append("[img] ");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= v.size()) {
                return spannableStringBuilder;
            }
            AlaLiveMarkData alaLiveMarkData = v.get(i3);
            if (alaLiveMarkData != null) {
                int i4 = i3 * length;
                int i5 = (i4 + length) - 1;
                if (1 == alaLiveMarkData.type) {
                    String str = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10) + "*_*" + aVar.level_id;
                    com.baidu.live.view.c cVar = com.baidu.live.view.c.bFL.get(str);
                    if (cVar == null) {
                        cVar = new com.baidu.live.view.b(this.mContext, alaLiveMarkData, aVar.level_id, this.bjs, new c.a() { // from class: com.baidu.live.im.a.b.1
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.Lz();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar2, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bFL.put(str, cVar);
                    }
                    spannableStringBuilder.setSpan(cVar, i4, i5, 17);
                } else {
                    String genCacheKey = BdResourceLoader.getInstance().genCacheKey(alaLiveMarkData.mark_pic, 10);
                    com.baidu.live.view.c cVar2 = com.baidu.live.view.c.bFL.get(genCacheKey);
                    if (cVar2 == null) {
                        cVar2 = new com.baidu.live.view.c(this.mContext, alaLiveMarkData, this.bjs, new c.a() { // from class: com.baidu.live.im.a.b.2
                            @Override // com.baidu.live.view.c.a
                            public void d(Bitmap bitmap) {
                                b.this.Lz();
                            }

                            @Override // com.baidu.live.view.c.a
                            public void a(com.baidu.live.view.c cVar3, Bitmap bitmap) {
                            }
                        });
                        com.baidu.live.view.c.bFL.put(genCacheKey, cVar2);
                    }
                    spannableStringBuilder.setSpan(cVar2, i4, i5, 17);
                }
            }
            i2 = i3 + 1;
        }
    }

    private List<AlaLiveMarkData> v(List<AlaLiveMarkData> list) {
        if (!ListUtils.isEmpty(list)) {
            LinkedList linkedList = new LinkedList();
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type && 6 != alaLiveMarkData.type) {
                    if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                        linkedList.add(alaLiveMarkData);
                    } else if (alaLiveMarkData.anchor_user_id.equals(this.aEz)) {
                        linkedList.add(alaLiveMarkData);
                    }
                }
            }
            return linkedList.size() >= 6 ? linkedList.subList(0, 6) : linkedList;
        }
        return list;
    }

    protected int T(List<AlaLiveMarkData> list) {
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
    public void Lz() {
        long currentTimeMillis = System.currentTimeMillis() - this.bju;
        if (currentTimeMillis > 500) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
            this.bju = System.currentTimeMillis();
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.mHandler.removeCallbacks(this);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913069));
                b.this.bju = System.currentTimeMillis();
            }
        }, currentTimeMillis);
    }

    public void b(String str, String str2, boolean z, String str3) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.bjr = z;
        this.aEz = str3;
    }

    public boolean LA() {
        return this.bjr;
    }

    /* renamed from: com.baidu.live.im.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0185b extends ClickableSpan implements g.a {
        private boolean aJi;
        private String aZS;
        private int bjv;
        private int bjw;
        private boolean bjx;
        private com.baidu.live.data.a bjz;
        private String groupId;
        private String liveId;

        C0185b(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bjz = null;
            this.bjz = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aJi = z;
            this.aZS = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bjp) {
                if (this.bjx) {
                    textPaint.setColor(this.bjv);
                    textPaint.setAlpha(this.bjw);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bjp) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bjz instanceof com.baidu.live.data.a) {
                str = this.bjz.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bjz.userId, this.bjz.userName, this.bjz.portrait, this.bjz.sex, this.bjz.level_id, null, null, 0L, this.bjz.aGK, this.bjz.aGL, this.bjz.aGM, this.groupId, this.liveId, this.aJi, this.aZS, str, this.bjz.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Lh() {
            if (this.bjz != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(TbadkCoreApplication.getInst());
                } else if (this.bjz.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bjz));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ClickableSpan implements g.a {
        private boolean aJi;
        private String aZS;
        private int bjv;
        private int bjw;
        private boolean bjx;
        private com.baidu.live.data.a bjz;
        private String groupId;
        private String liveId;

        a(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bjz = null;
            this.bjz = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aJi = z;
            this.aZS = str3;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (1 == b.bjp) {
                if (this.bjx) {
                    textPaint.setColor(this.bjv);
                    textPaint.setAlpha(this.bjw);
                } else {
                    textPaint.setColor(-5462);
                    textPaint.setAlpha(255);
                }
            } else if (2 == b.bjp) {
                textPaint.setColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_cont_d));
            }
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str = null;
            if (this.bjz instanceof com.baidu.live.data.a) {
                str = this.bjz.appId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bjz.userId, this.bjz.userName, this.bjz.portrait, this.bjz.sex, this.bjz.level_id, null, null, 0L, this.bjz.aGK, this.bjz.aGL, this.bjz.aGM, this.groupId, this.liveId, this.aJi, this.aZS, str, this.bjz.getNameShow(), "")));
        }

        @Override // com.baidu.live.im.g.a
        public void Lh() {
            if (this.bjz != null) {
                if (this.bjz.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(a.i.ala_cannot_reply_self));
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bjz));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements View.OnClickListener {
        private boolean aJi;
        private String aZS;
        private com.baidu.live.data.a bjz;
        private String groupId;
        private String liveId;

        public c(com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3) {
            this.bjz = null;
            this.bjz = aVar;
            this.groupId = str;
            this.liveId = str2;
            this.aJi = z;
            this.aZS = str3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(view.getContext(), this.bjz.userId, this.bjz.userName, this.bjz.portrait, this.bjz.sex, this.bjz.level_id, null, null, 0L, this.bjz.aGK, this.bjz.aGL, this.bjz.aGM, this.groupId, this.liveId, this.aJi, this.aZS, this.bjz.appId, this.bjz.getNameShow(), "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean LC() {
        return 2 != bjp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void LD() {
        this.bjq.bkA = true;
        this.bjq.bkB = false;
        this.bjq.isNormal = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void LE() {
        this.bjq.bkA = false;
        this.bjq.bkB = false;
        this.bjq.isNormal = false;
    }

    public void bW(boolean z) {
        this.bjs = z;
    }

    public void bX(boolean z) {
        this.bjt = z;
    }
}
