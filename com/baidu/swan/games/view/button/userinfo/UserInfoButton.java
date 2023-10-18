package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.o84;
import com.baidu.tieba.q84;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes4.dex */
    public class a implements q84.b {
        public a() {
        }

        @Override // com.baidu.tieba.q84.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.A(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    public void A(JSONObject jSONObject) {
        o84 o84Var = new o84();
        o84Var.data = jSONObject;
        m(o84Var);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        new q84().a(new a());
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
