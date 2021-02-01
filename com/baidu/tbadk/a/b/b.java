package com.baidu.tbadk.a.b;

import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public final class b {
    public static void bl(View view) {
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.rightMargin = 0;
            marginLayoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static void bm(View view) {
        if (view != null) {
            ap.setBackgroundColor(view, R.color.CAM_X0202);
        }
    }

    public static void a(cb cbVar, int[] iArr) {
        if (iArr != null && iArr.length == 2 && cbVar != null && d.biX()) {
            int size = View.MeasureSpec.getSize(l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
            int i = dimensionPixelSize + (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2);
            MediaData mediaData = (MediaData) y.getItem(cbVar.bnZ(), 0);
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
        if (mediaData != null && d.biX()) {
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

    public static void g(TextView textView) {
        if (textView != null) {
            if (d.biX()) {
                textView.setTypeface(Typeface.DEFAULT);
                textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds39));
                return;
            }
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextSize(0, textView.getResources().getDimension(R.dimen.tbds42));
        }
    }

    public static void h(TextView textView) {
        if (textView != null) {
            if (d.biX()) {
                ap.setViewTextColor(textView, R.color.CAM_X0105);
            } else {
                ap.setViewTextColor(textView, R.color.CAM_X0106);
            }
        }
    }

    public static void m(View view, int i) {
        if (view != null) {
            if (d.biX()) {
                view.setBackgroundResource(R.drawable.bg_img_mask);
            } else if (i > 0) {
                view.setBackgroundResource(i);
            } else {
                view.setBackgroundDrawable(null);
            }
        }
    }

    public static void j(View view, int i, int i2) {
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (d.biX()) {
                marginLayoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), i2);
            } else {
                marginLayoutParams.topMargin = l.getDimens(TbadkCoreApplication.getInst(), i);
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static int aH(int i, int i2) {
        return d.biX() ? i2 : i;
    }

    public static void a(TextView textView, int i, int i2) {
        if (textView != null && Build.VERSION.SDK_INT >= 16) {
            if (d.biX()) {
                textView.setLineSpacing(l.getDimens(textView.getContext(), i2), textView.getLineSpacingMultiplier());
            } else {
                textView.setLineSpacing(l.getDimens(textView.getContext(), i), textView.getLineSpacingMultiplier());
            }
        }
    }

    public static boolean a(ViewGroup.LayoutParams layoutParams, boolean z, com.baidu.tieba.play.operableVideoView.a aVar, int i, int i2) {
        if (layoutParams != null && d.biX()) {
            int size = View.MeasureSpec.getSize(l.getScreenDimensions(TbadkCoreApplication.getInst().getContext())[0]) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004) * 2);
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
            int i3 = (((int) ((size - (dimensionPixelSize * 2)) / 3.0f)) * 2) + dimensionPixelSize;
            layoutParams.width = i3;
            layoutParams.height = (i3 * 4) / 3;
            z = (layoutParams.width == i && layoutParams.height == i2) ? false : true;
            if (aVar != null) {
                aVar.Hr(0);
            }
        }
        return z;
    }

    public static boolean a(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i, int i2, boolean z) {
        if (layoutParams != null && layoutParams2 != null && d.biX()) {
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

    public static int bjL() {
        return UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
    }
}
