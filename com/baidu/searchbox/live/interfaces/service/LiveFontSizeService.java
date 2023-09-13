package com.baidu.searchbox.live.interfaces.service;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.sina.weibo.sdk.utils.ResourceManager;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000  2\u00020\u0001:\u0003 !\"J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ/\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u001dJ3\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService;", "Lkotlin/Any;", "", "getFontSizeType", "()I", "Landroid/graphics/Bitmap;", "bitmap", "type", "numRoundPolicy", "getScaledBitmap", "(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", ResourceManager.DRAWABLE, "getScaledDrawable", "(Landroid/graphics/drawable/Drawable;II)Landroid/graphics/drawable/Drawable;", "", "size", "getScaledSize", "(FII)I", "Landroid/view/View;", "view", "width", "height", "", "setScaledSize", "(Landroid/view/View;FFII)V", "Landroid/widget/TextView;", Config.TARGET_SDK_VERSION, "unit", "(Landroid/widget/TextView;IFII)V", "setScaledWidth", "(Landroid/view/View;FII)V", "Companion", "FontSizeRoundPolicy", "SizeType", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface LiveFontSizeService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$FontSizeRoundPolicy;", "", "NUM_ROUND_POLICY_CEILING", "I", "NUM_ROUND_POLICY_DEFAULT", "NUM_ROUND_POLICY_FLOOR", "NUM_ROUND_POLICY_NEAREST", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class FontSizeRoundPolicy {
        public static final FontSizeRoundPolicy INSTANCE = new FontSizeRoundPolicy();
        public static final int NUM_ROUND_POLICY_CEILING = 0;
        public static final int NUM_ROUND_POLICY_DEFAULT = 2;
        public static final int NUM_ROUND_POLICY_FLOOR = 1;
        public static final int NUM_ROUND_POLICY_NEAREST = 2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$SizeType;", "", "CONTENT", "I", "FRAMEWORK", IEruptionStrategyGroup.STRATEGY_MODIFIER_H, ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class SizeType {
        public static final int CONTENT = 1;
        public static final int FRAMEWORK = 0;
        public static final int H = 2;
        public static final SizeType INSTANCE = new SizeType();

        /* renamed from: T  reason: collision with root package name */
        public static final int f1060T = 3;
    }

    int getFontSizeType();

    Bitmap getScaledBitmap(Bitmap bitmap, int i, int i2);

    Drawable getScaledDrawable(Drawable drawable, int i, int i2);

    int getScaledSize(float f, int i, int i2);

    void setScaledSize(View view2, float f, float f2, int i, int i2);

    void setScaledSize(TextView textView, int i, float f, int i2, int i3);

    void setScaledWidth(View view2, float f, int i, int i2);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_FONT_SIZE);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Bitmap getScaledBitmap$default(LiveFontSizeService liveFontSizeService, Bitmap bitmap, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = 2;
                }
                return liveFontSizeService.getScaledBitmap(bitmap, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getScaledBitmap");
        }

        public static /* synthetic */ Drawable getScaledDrawable$default(LiveFontSizeService liveFontSizeService, Drawable drawable, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = 2;
                }
                return liveFontSizeService.getScaledDrawable(drawable, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getScaledDrawable");
        }

        public static /* synthetic */ int getScaledSize$default(LiveFontSizeService liveFontSizeService, float f, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = 2;
                }
                return liveFontSizeService.getScaledSize(f, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getScaledSize");
        }

        public static /* synthetic */ void setScaledSize$default(LiveFontSizeService liveFontSizeService, View view2, float f, float f2, int i, int i2, int i3, Object obj) {
            int i4;
            int i5;
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    i4 = 0;
                } else {
                    i4 = i;
                }
                if ((i3 & 16) != 0) {
                    i5 = 2;
                } else {
                    i5 = i2;
                }
                liveFontSizeService.setScaledSize(view2, f, f2, i4, i5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setScaledSize");
        }

        public static /* synthetic */ void setScaledSize$default(LiveFontSizeService liveFontSizeService, TextView textView, int i, float f, int i2, int i3, int i4, Object obj) {
            int i5;
            int i6;
            if (obj == null) {
                if ((i4 & 8) != 0) {
                    i5 = 0;
                } else {
                    i5 = i2;
                }
                if ((i4 & 16) != 0) {
                    i6 = 2;
                } else {
                    i6 = i3;
                }
                liveFontSizeService.setScaledSize(textView, i, f, i5, i6);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setScaledSize");
        }

        public static /* synthetic */ void setScaledWidth$default(LiveFontSizeService liveFontSizeService, View view2, float f, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    i = 0;
                }
                if ((i3 & 8) != 0) {
                    i2 = 2;
                }
                liveFontSizeService.setScaledWidth(view2, f, i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setScaledWidth");
        }
    }
}
