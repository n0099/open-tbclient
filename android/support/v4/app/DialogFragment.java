package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    int f274a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = false;
            if (this.f != null) {
                this.f.dismiss();
                this.f = null;
            }
            this.g = true;
            if (this.e >= 0) {
                k().a(this.e, 1);
                this.e = -1;
                return;
            }
            ae a2 = k().a();
            a2.a(this);
            if (z) {
                a2.b();
            } else {
                a2.a();
            }
        }
    }

    public int a() {
        return this.b;
    }

    @Override // android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        if (!this.i) {
            this.h = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void b() {
        super.b();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = this.G == 0;
        if (bundle != null) {
            this.f274a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public LayoutInflater b(Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = c(bundle);
        switch (this.f274a) {
            case 3:
                this.f.getWindow().addFlags(24);
            case 1:
            case 2:
                this.f.requestWindowFeature(1);
                break;
        }
        if (this.f != null) {
            return (LayoutInflater) this.f.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.C.getSystemService("layout_inflater");
    }

    public Dialog c(Bundle bundle) {
        return new Dialog(i(), a());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g) {
            a(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        Bundle bundle2;
        super.d(bundle);
        if (this.d) {
            View q = q();
            if (q != null) {
                if (q.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(q);
            }
            this.f.setOwnerActivity(i());
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.f.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.e(bundle);
        if (this.f != null && (onSaveInstanceState = this.f.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        if (this.f274a != 0) {
            bundle.putInt("android:style", this.f274a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void d() {
        super.d();
        if (this.f != null) {
            this.f.hide();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void e() {
        super.e();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }
}
