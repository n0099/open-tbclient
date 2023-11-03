package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TooltipPopup {
    public static final String TAG = "TooltipPopup";
    public final View mContentView;
    public final Context mContext;
    public final TextView mMessageView;
    public final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
    public final Rect mTmpDisplayFrame = new Rect();
    public final int[] mTmpAnchorPos = new int[2];
    public final int[] mTmpAppPos = new int[2];

    public TooltipPopup(@NonNull Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d001b, (ViewGroup) null);
        this.mContentView = inflate;
        this.mMessageView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0917a9);
        this.mLayoutParams.setTitle(TooltipPopup.class.getSimpleName());
        this.mLayoutParams.packageName = this.mContext.getPackageName();
        WindowManager.LayoutParams layoutParams = this.mLayoutParams;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.obfuscated_res_0x7f100008;
        layoutParams.flags = 24;
    }

    private void computePosition(View view2, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        int i4;
        int i5;
        layoutParams.token = view2.getApplicationWindowToken();
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070b39);
        if (view2.getWidth() < dimensionPixelOffset) {
            i = view2.getWidth() / 2;
        }
        if (view2.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070b38);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view2.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.mContext.getResources();
        if (z) {
            i4 = R.dimen.obfuscated_res_0x7f070b3c;
        } else {
            i4 = R.dimen.obfuscated_res_0x7f070b3b;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i4);
        View appRootView = getAppRootView(view2);
        if (appRootView == null) {
            Log.e(TAG, "Cannot find app view");
            return;
        }
        appRootView.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        Rect rect = this.mTmpDisplayFrame;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources2 = this.mContext.getResources();
            int identifier = resources2.getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
            if (identifier != 0) {
                i5 = resources2.getDimensionPixelSize(identifier);
            } else {
                i5 = 0;
            }
            DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
            this.mTmpDisplayFrame.set(0, i5, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        appRootView.getLocationOnScreen(this.mTmpAppPos);
        view2.getLocationOnScreen(this.mTmpAnchorPos);
        int[] iArr = this.mTmpAnchorPos;
        int i6 = iArr[0];
        int[] iArr2 = this.mTmpAppPos;
        iArr[0] = i6 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (appRootView.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mContentView.getMeasuredHeight();
        int[] iArr3 = this.mTmpAnchorPos;
        int i7 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i8 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i7 >= 0) {
                layoutParams.y = i7;
            } else {
                layoutParams.y = i8;
            }
        } else if (measuredHeight + i8 <= this.mTmpDisplayFrame.height()) {
            layoutParams.y = i8;
        } else {
            layoutParams.y = i7;
        }
    }

    public static View getAppRootView(View view2) {
        View rootView = view2.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view2.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public void hide() {
        if (!isShowing()) {
            return;
        }
        ((WindowManager) this.mContext.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).removeView(this.mContentView);
    }

    public boolean isShowing() {
        if (this.mContentView.getParent() != null) {
            return true;
        }
        return false;
    }

    public void show(View view2, int i, int i2, boolean z, CharSequence charSequence) {
        if (isShowing()) {
            hide();
        }
        this.mMessageView.setText(charSequence);
        computePosition(view2, i, i2, z, this.mLayoutParams);
        ((WindowManager) this.mContext.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).addView(this.mContentView, this.mLayoutParams);
    }
}
