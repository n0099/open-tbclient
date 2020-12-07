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
/* loaded from: classes6.dex */
public class ShareModel implements Parcelable {
    public static final Parcelable.Creator<ShareModel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private SapiAccount f3506a;
    private List<SapiAccount> b;
    private ShareEvent c;
    private String d;
    private LoginShareStrategy e;

    /* loaded from: classes6.dex */
    static class a implements Parcelable.Creator<ShareModel> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareModel createFromParcel(Parcel parcel) {
            return new ShareModel(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareModel[] newArray(int i) {
            return new ShareModel[i];
        }
    }

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
        return "ShareModel{currentAccount=" + this.f3506a + ", shareAccounts=" + this.b + ", event=" + this.c + ", from='" + this.d + "', senderStrategy=" + this.e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.c);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.f3506a, i);
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
            arrayList.add(c.b(context, sapiAccount));
        }
        a(arrayList);
        SapiAccount sapiAccount2 = this.f3506a;
        if (sapiAccount2 != null) {
            this.f3506a = c.b(context, sapiAccount2);
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        this.d = c.b(context, this.d);
    }

    ShareModel(Parcel parcel) {
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
        this.f3506a = sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.d = str;
    }

    private void a(Parcel parcel) {
        this.c = (ShareEvent) parcel.readSerializable();
        parcel.readTypedList(this.b, SapiAccount.CREATOR);
        this.f3506a = (SapiAccount) parcel.readParcelable(SapiAccount.class.getClassLoader());
        this.e = (LoginShareStrategy) parcel.readSerializable();
        this.d = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : c()) {
            arrayList.add(c.a(context, sapiAccount));
        }
        a(arrayList);
        SapiAccount sapiAccount2 = this.f3506a;
        if (sapiAccount2 != null) {
            this.f3506a = c.a(context, sapiAccount2);
        }
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        this.d = c.a(context, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareModel(ShareEvent shareEvent) {
        this.b = new ArrayList();
        this.c = shareEvent;
    }

    ShareModel(ShareEvent shareEvent, SapiAccount sapiAccount) {
        this(shareEvent);
        this.f3506a = sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareModel(ShareEvent shareEvent, SapiAccount sapiAccount, List<SapiAccount> list) {
        this(shareEvent, sapiAccount);
        this.b = list;
    }
}
