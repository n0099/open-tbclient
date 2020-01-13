package com.baidu.live.im.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.gift.s;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends b {
    private boolean afX;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context, com.baidu.live.im.a.ane);
        this.afX = true;
    }

    @Override // com.baidu.live.im.a.b
    protected void vl() {
        if (vm()) {
            vn();
        } else {
            vo();
        }
    }

    @Override // com.baidu.live.im.a.b
    protected int getColor() {
        if (vm()) {
            return -1647769;
        }
        return TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_cp_other_b);
    }

    @Override // com.baidu.live.im.a.b
    protected SpannableStringBuilder a(com.baidu.live.im.data.a aVar, final com.baidu.live.im.c cVar) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        a(spannableStringBuilder, aVar.vq(), cVar, false, false);
        final a h = h(aVar);
        String str = (h == null || TextUtils.isEmpty(h.aeQ)) ? "1" : h.aeQ;
        String string = (h == null || TextUtils.isEmpty(h.giftName)) ? this.mContext.getString(a.i.sdk_gift) : h.giftName;
        if (h != null && !TextUtils.isEmpty(h.apR)) {
            String str2 = h.apR;
        }
        String format = String.format(this.mContext.getString(a.i.ala_rec_gift), str, string);
        SpannableString valueOf = SpannableString.valueOf(format);
        if (format != null) {
            valueOf.setSpan(new ForegroundColorSpan(getColor()), 0, valueOf.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) valueOf);
        if (h != null && !TextUtils.isEmpty(h.apQ)) {
            this.afX = true;
            BdResourceLoader.getInstance().loadResource(h.apQ, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.im.a.c.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str3, int i) {
                    Bitmap rawBitmap;
                    Bitmap copy;
                    Bitmap copy2;
                    super.onLoaded((AnonymousClass1) bdImage, str3, i);
                    if (bdImage != null && (rawBitmap = bdImage.getRawBitmap()) != null && !rawBitmap.isRecycled()) {
                        try {
                            if (rawBitmap.getConfig() == null) {
                                copy2 = rawBitmap.copy(Bitmap.Config.ARGB_8888, false);
                            } else {
                                copy2 = rawBitmap.copy(rawBitmap.getConfig(), false);
                            }
                            copy = copy2;
                        } catch (OutOfMemoryError e) {
                            BdLog.e(e);
                            if (rawBitmap.getConfig() == null) {
                                try {
                                    copy = rawBitmap.copy(Bitmap.Config.RGB_565, false);
                                } catch (OutOfMemoryError e2) {
                                    BdLog.e(e2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (copy != null) {
                            int dimensionPixelSize = c.this.mContext.getResources().getDimensionPixelSize(a.e.sdk_tbds36);
                            try {
                                Bitmap resizeBitmap = BdBitmapHelper.getInstance().resizeBitmap(copy, dimensionPixelSize, dimensionPixelSize);
                                if (resizeBitmap != copy) {
                                    copy.recycle();
                                }
                                if (resizeBitmap != null) {
                                    CenteredImageSpan centeredImageSpan = new CenteredImageSpan(c.this.mContext, resizeBitmap);
                                    SpannableString spannableString = new SpannableString(" [img]");
                                    spannableString.setSpan(centeredImageSpan, 1, spannableString.length(), 33);
                                    spannableStringBuilder.append((CharSequence) spannableString);
                                    if (c.this.apB && h != null && !TextUtils.isEmpty(h.apR)) {
                                        SpannableString valueOf2 = SpannableString.valueOf(String.format(c.this.mContext.getString(a.i.ala_rec_gift_charm_value), h.apR));
                                        valueOf2.setSpan(new ForegroundColorSpan(c.this.getColor()), 0, valueOf2.length(), 33);
                                        spannableStringBuilder.append((CharSequence) valueOf2);
                                    }
                                    if (s.di(h.giftId) && !s.dg(h.giftId) && s.dh(h.giftId)) {
                                        SpannableString valueOf3 = SpannableString.valueOf(c.this.mContext.getString(a.i.ala_dynamic_gift_downloading));
                                        valueOf3.setSpan(new ForegroundColorSpan(c.this.getColor()), 0, valueOf3.length(), 33);
                                        spannableStringBuilder.append((CharSequence) valueOf3);
                                    }
                                    if (!h.apS && h.apT > 0.0d) {
                                        com.baidu.live.im.view.a aVar2 = new com.baidu.live.im.view.a(c.this.mContext, "*" + h.apT + "倍");
                                        SpannableString spannableString2 = new SpannableString(" rate");
                                        spannableString2.setSpan(aVar2, 1, spannableString2.length(), 33);
                                        spannableStringBuilder.append((CharSequence) spannableString2);
                                    }
                                    if (!c.this.afX) {
                                        cVar.anw.setText(spannableStringBuilder);
                                    }
                                }
                            } catch (OutOfMemoryError e3) {
                                BdLog.e(e3);
                                if (copy != null) {
                                    copy.recycle();
                                }
                            }
                        }
                    }
                }
            }, null);
            this.afX = false;
        }
        return spannableStringBuilder;
    }

    private a h(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            a aVar2 = new a();
            aVar2.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            aVar2.aeQ = jSONObject.optString("gift_count");
            aVar2.giftName = jSONObject.optString("gift_name");
            aVar2.apQ = jSONObject.optString("gift_url");
            aVar2.apR = jSONObject.optString("charm_value");
            aVar2.apS = jSONObject.optInt("is_free") == 1;
            aVar2.apT = jSONObject.optDouble("gift_rate");
            com.baidu.live.gift.g df = s.df(aVar2.giftId);
            if (df != null) {
                aVar2.giftName = df.qF();
                aVar2.apQ = df.qH();
                return aVar2;
            }
            return aVar2;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        public String aeQ;
        public String apQ;
        public String apR;
        public boolean apS;
        public double apT;
        public String giftId;
        public String giftName;

        private a() {
        }
    }
}
