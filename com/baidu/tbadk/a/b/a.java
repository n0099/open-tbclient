package com.baidu.tbadk.a.b;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport) {
        if (view != null) {
            boolean bad = d.bad();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (bad) {
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.height = l.getDimens(view.getContext(), R.dimen.tbds17);
            } else {
                marginLayoutParams.leftMargin = l.getDimens(view.getContext(), R.dimen.tbds44);
                marginLayoutParams.rightMargin = l.getDimens(view.getContext(), R.dimen.tbds44);
                marginLayoutParams.height = l.getDimens(view.getContext(), R.dimen.tbds1);
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static void aW(View view) {
        if (view != null) {
            if (((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin > 0) {
                ap.setBackgroundResource(view, R.color.cp_bg_line_b);
            } else {
                ap.setBackgroundResource(view, R.color.cp_bg_line_c);
            }
        }
    }

    public static void a(bw bwVar, int[] iArr) {
        if (iArr != null && iArr.length == 2 && bwVar != null && d.bad()) {
            int size = View.MeasureSpec.getSize(l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i = dimensionPixelSize + (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2);
            MediaData mediaData = (MediaData) y.getItem(bwVar.beN(), 0);
            if (mediaData != null && mediaData.picWidth > 0 && mediaData.picHeight > 0) {
                if (mediaData.picWidth == mediaData.picHeight) {
                    iArr[0] = i;
                    iArr[1] = i;
                } else if (mediaData.picWidth > mediaData.picHeight) {
                    iArr[0] = i;
                    iArr[1] = (i * 3) / 4;
                } else {
                    iArr[0] = i;
                    iArr[1] = (i * 4) / 3;
                }
            }
        }
    }

    public static int[] c(MediaData mediaData) {
        int[] iArr = new int[2];
        if (mediaData != null && d.bad()) {
            int size = View.MeasureSpec.getSize(l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
            if (mediaData.picWidth > 0 && mediaData.picHeight > 0) {
                if (mediaData.picWidth == mediaData.picHeight) {
                    iArr[0] = i;
                    iArr[1] = i;
                } else if (mediaData.picWidth > mediaData.picHeight) {
                    iArr[0] = i;
                    iArr[1] = (i * 3) / 4;
                } else {
                    iArr[0] = i;
                    iArr[1] = (i * 4) / 3;
                }
            }
        }
        return iArr;
    }

    public static void a(TextView textView) {
        if (textView != null) {
            if (d.bad()) {
                textView.setTypeface(Typeface.DEFAULT);
                textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds39));
                return;
            }
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds42));
        }
    }

    public static void b(TextView textView) {
        if (textView != null) {
            if (d.bad()) {
                ap.setViewTextColor(textView, R.color.cp_cont_b);
            } else {
                ap.setViewTextColor(textView, R.color.cp_cont_f);
            }
        }
    }

    public static void h(View view, int i) {
        if (view != null) {
            if (d.bad()) {
                view.setBackgroundResource(R.drawable.bg_img_mask);
            } else if (i > 0) {
                view.setBackgroundResource(i);
            } else {
                view.setBackgroundDrawable(null);
            }
        }
    }

    public static void d(View view, int i, int i2) {
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (d.bad()) {
                marginLayoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), i2);
            } else {
                marginLayoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), i);
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static int aL(int i, int i2) {
        return d.bad() ? i2 : i;
    }

    public static void a(TextView textView, int i, int i2) {
        if (textView != null && Build.VERSION.SDK_INT >= 16) {
            if (d.bad()) {
                textView.setLineSpacing(l.getDimens(textView.getContext(), i2), textView.getLineSpacingMultiplier());
            } else {
                textView.setLineSpacing(l.getDimens(textView.getContext(), i), textView.getLineSpacingMultiplier());
            }
        }
    }

    public static boolean a(ViewGroup.LayoutParams layoutParams, boolean z, com.baidu.tieba.play.operableVideoView.a aVar, int i, int i2) {
        if (layoutParams == null || aVar == null || !d.bad()) {
            return z;
        }
        int size = View.MeasureSpec.getSize(l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        int i3 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
        layoutParams.width = i3;
        layoutParams.height = (i3 * 4) / 3;
        boolean z2 = (layoutParams.width == i && layoutParams.height == i2) ? false : true;
        aVar.FK(0);
        return z2;
    }

    public static boolean a(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i, int i2, boolean z) {
        if (layoutParams != null && layoutParams2 != null && d.bad()) {
            int size = View.MeasureSpec.getSize(l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i3 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
            layoutParams2.width = (l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44) * 2) + i3;
            int dimens = ((i3 * 4) / 3) + l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
            layoutParams2.height = dimens;
            layoutParams.height = dimens;
            return true;
        }
        return z;
    }
}
