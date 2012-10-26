package com.baidu.loginshare;

import com.baidu.share.Crypto;
import com.baidu.share.IShareListener;
import com.baidu.share.ShareModel;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements IShareListener {
    private /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.share.IShareListener
    public final void onShareEvent(ShareModel shareModel) {
        String str = shareModel.mAction;
        if (!Keystore.c().equals(str)) {
            if (Keystore.d().equals(str)) {
                f.b(this.a, shareModel);
                return;
            } else if (!Keystore.a().equals(str)) {
                if (Keystore.b().equals(str)) {
                    f.d(this.a, shareModel);
                    return;
                }
                return;
            } else {
                f fVar = this.a;
                String str2 = shareModel.mFrom;
                if (l.a(fVar.d.a(Keystore.k()))) {
                    String encrypt = Crypto.encrypt(fVar.a, fVar.d.a(Keystore.i()));
                    if (l.a(encrypt)) {
                        ShareModel shareModel2 = new ShareModel();
                        shareModel2.mAction = Keystore.b();
                        shareModel2.mData.put(Keystore.k(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.k())));
                        shareModel2.mData.put(Keystore.f(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.f())));
                        shareModel2.mData.put(Keystore.g(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.g())));
                        shareModel2.mData.put(Keystore.h(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.h())));
                        shareModel2.mData.put(Keystore.i(), encrypt);
                        shareModel2.mData.put(Keystore.j(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.j())));
                        shareModel2.mData.put(Keystore.m(), Crypto.encrypt(fVar.a, fVar.d.a(Keystore.m())));
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str2);
                        fVar.b.share(shareModel2, arrayList);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        f fVar2 = this.a;
        HashMap hashMap = shareModel.mData;
        Token token = new Token();
        HashMap hashMap2 = new HashMap();
        for (String str3 : hashMap.keySet()) {
            if (Keystore.f().equals(str3)) {
                token.mUsername = Crypto.decrypt(fVar2.a, (String) hashMap.get(str3));
            } else if (Keystore.g().equals(str3)) {
                token.mEmail = Crypto.decrypt(fVar2.a, (String) hashMap.get(str3));
            } else if (Keystore.h().equals(str3)) {
                token.mPhoneNumber = Crypto.decrypt(fVar2.a, (String) hashMap.get(str3));
            } else if (Keystore.i().equals(str3)) {
                String str4 = (String) hashMap.get(str3);
                if (!l.a(str4)) {
                    return;
                }
                token.mBduss = Crypto.decrypt(fVar2.a, str4);
            } else if (Keystore.j().equals(str3)) {
                token.mPtoken = Crypto.decrypt(fVar2.a, (String) hashMap.get(str3));
            } else {
                String str5 = (String) hashMap.get(str3);
                hashMap2.put(str3, str5);
                token.mExtras.put(str3, Crypto.decrypt(fVar2.a, str5));
            }
        }
        if (f.c(token)) {
            fVar2.a(true, token.mUsername, token.mEmail, token.mPhoneNumber, token.mBduss, token.mPtoken, token.mExtras);
            token.mEvent = LoginShareEvent.VALID;
            fVar2.e = token;
            fVar2.f.a(2, token.mBduss);
            fVar2.h.a(token);
        }
    }
}
