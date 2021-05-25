package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import d.a.l0.h.o0.d.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes3.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.a.l0.h.o0.d.b.c.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.u(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        new c().a(new a());
    }

    public void u(JSONObject jSONObject) {
        d.a.l0.h.o0.d.b.a aVar = new d.a.l0.h.o0.d.b.a();
        aVar.data = jSONObject;
        k(aVar);
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
