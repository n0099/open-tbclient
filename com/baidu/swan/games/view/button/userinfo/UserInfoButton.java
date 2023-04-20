package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.ua4;
import com.baidu.tieba.wa4;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes3.dex */
    public class a implements wa4.b {
        public a() {
        }

        @Override // com.baidu.tieba.wa4.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.A(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    public void A(JSONObject jSONObject) {
        ua4 ua4Var = new ua4();
        ua4Var.data = jSONObject;
        o(ua4Var);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        new wa4().a(new a());
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
