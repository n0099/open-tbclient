package com.baidu.sapi2.share;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ShareModel implements Parcelable {
    public static final Parcelable.Creator<ShareModel> CREATOR = new o();
    private SapiAccount a;
    private List<SapiAccount> b;
    private ShareEvent c;
    private String d;
    private LoginShareStrategy e;

    ShareModel() {
        this.b = new ArrayList();
    }

    void a(List<SapiAccount> list) {
        if (list != null) {
            this.b = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<SapiAccount> c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ShareModel{currentAccount=" + this.a + ", shareAccounts=" + this.b + ", event=" + this.c + ", from='" + this.d + "', senderStrategy=" + this.e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.c);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.a, i);
        parcel.writeSerializable(this.e);
        parcel.writeString(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LoginShareStrategy loginShareStrategy) {
        this.e = loginShareStrategy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : c()) {
            arrayList.add(n.b(context, sapiAccount));
        }
        a(arrayList);
        SapiAccount sapiAccount2 = this.a;
        if (sapiAccount2 != null) {
            this.a = n.b(context, sapiAccount2);
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        this.d = n.b(context, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareModel(Parcel parcel) {
        this.b = new ArrayList();
        a(parcel);
    }

    void a(ShareEvent shareEvent) {
        this.c = shareEvent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareEvent a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiAccount sapiAccount) {
        this.a = sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareModel(ShareEvent shareEvent) {
        this.b = new ArrayList();
        this.c = shareEvent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.d = str;
    }

    private void a(Parcel parcel) {
        this.c = (ShareEvent) parcel.readSerializable();
        parcel.readTypedList(this.b, SapiAccount.CREATOR);
        this.a = (SapiAccount) parcel.readParcelable(SapiAccount.class.getClassLoader());
        this.e = (LoginShareStrategy) parcel.readSerializable();
        this.d = parcel.readString();
    }

    ShareModel(ShareEvent shareEvent, SapiAccount sapiAccount) {
        this(shareEvent);
        this.a = sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareModel(ShareEvent shareEvent, SapiAccount sapiAccount, List<SapiAccount> list) {
        this(shareEvent, sapiAccount);
        this.b = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : c()) {
            arrayList.add(n.a(context, sapiAccount));
        }
        a(arrayList);
        SapiAccount sapiAccount2 = this.a;
        if (sapiAccount2 != null) {
            this.a = n.a(context, sapiAccount2);
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        this.d = n.a(context, this.d);
    }
}
