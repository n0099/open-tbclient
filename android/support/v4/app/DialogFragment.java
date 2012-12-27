package android.support.v4.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    int a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;

    public int a() {
        return this.b;
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = this.D == 0;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    void a(boolean z) {
        if (this.f != null) {
            this.f.dismiss();
            this.f = null;
        }
        this.h = true;
        if (this.e >= 0) {
            h().a(this.e, 1);
            this.e = -1;
            return;
        }
        q a = h().a();
        a.a(this);
        if (z) {
            a.b();
        } else {
            a.a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public LayoutInflater b(Bundle bundle) {
        if (this.d) {
            this.f = c(bundle);
            this.g = false;
            switch (this.a) {
                case 3:
                    this.f.getWindow().addFlags(24);
                case 1:
                case 2:
                    this.f.requestWindowFeature(1);
                    break;
            }
            return (LayoutInflater) this.f.getContext().getSystemService("layout_inflater");
        }
        return super.b(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void b() {
        super.b();
        if (this.f != null) {
            this.h = false;
            this.f.show();
        }
    }

    public Dialog c(Bundle bundle) {
        return new Dialog(g(), a());
    }

    @Override // android.support.v4.app.Fragment
    public void c() {
        super.c();
        if (this.f != null) {
            this.f.hide();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void d() {
        super.d();
        this.g = true;
        if (this.f != null) {
            this.h = true;
            this.f.dismiss();
            this.f = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        Bundle bundle2;
        super.d(bundle);
        if (this.d) {
            View i = i();
            if (i != null) {
                if (i.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(i);
            }
            this.f.setOwnerActivity(g());
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.f.onRestoreInstanceState(bundle2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.e(bundle);
        if (this.f != null && (onSaveInstanceState = this.f.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
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

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.h) {
            return;
        }
        a(true);
    }
}
