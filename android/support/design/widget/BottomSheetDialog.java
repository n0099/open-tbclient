package android.support.design.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.design.R;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatDialog;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> lI;
    private boolean lJ;
    private boolean lK;
    private BottomSheetBehavior.BottomSheetCallback lL;
    boolean mCancelable;

    public BottomSheetDialog(Context context) {
        this(context, 0);
    }

    public BottomSheetDialog(Context context, int i) {
        super(context, c(context, i));
        this.mCancelable = true;
        this.lJ = true;
        this.lL = new BottomSheetBehavior.BottomSheetCallback() { // from class: android.support.design.widget.BottomSheetDialog.2
            @Override // android.support.design.widget.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i2) {
                if (i2 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }

            @Override // android.support.design.widget.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f) {
            }
        };
        supportRequestWindowFeature(1);
    }

    protected BottomSheetDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mCancelable = true;
        this.lJ = true;
        this.lL = new BottomSheetBehavior.BottomSheetCallback() { // from class: android.support.design.widget.BottomSheetDialog.2
            @Override // android.support.design.widget.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i2) {
                if (i2 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }

            @Override // android.support.design.widget.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f) {
            }
        };
        supportRequestWindowFeature(1);
        this.mCancelable = z;
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(a(i, null, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    @Override // android.support.v7.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.mCancelable != z) {
            this.mCancelable = z;
            if (this.lI != null) {
                this.lI.setHideable(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.lJ = z;
        this.lK = true;
    }

    private View a(int i, View view, ViewGroup.LayoutParams layoutParams) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        this.lI = BottomSheetBehavior.from(frameLayout);
        this.lI.setBottomSheetCallback(this.lL);
        this.lI.setHideable(this.mCancelable);
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.BottomSheetDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BottomSheetDialog.this.mCancelable && BottomSheetDialog.this.isShowing() && BottomSheetDialog.this.aZ()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        return coordinatorLayout;
    }

    boolean aZ() {
        if (!this.lK) {
            if (Build.VERSION.SDK_INT < 11) {
                this.lJ = true;
            } else {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
                this.lJ = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            this.lK = true;
        }
        return this.lJ;
    }

    private static int c(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R.style.Theme_Design_Light_BottomSheetDialog;
        }
        return i;
    }
}
