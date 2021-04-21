package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import d.b.h0.g.k0.f.b.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes3.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.b.h0.g.k0.f.b.c.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.y(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        new c().a(new a());
    }

    public void y(JSONObject jSONObject) {
        d.b.h0.g.k0.f.b.a aVar = new d.b.h0.g.k0.f.b.a();
        aVar.data = jSONObject;
        l(aVar);
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
