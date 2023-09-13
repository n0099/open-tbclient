package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.ge4;
import com.baidu.tieba.ie4;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes4.dex */
    public class a implements ie4.b {
        public a() {
        }

        @Override // com.baidu.tieba.ie4.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.A(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    public void A(JSONObject jSONObject) {
        ge4 ge4Var = new ge4();
        ge4Var.data = jSONObject;
        m(ge4Var);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        new ie4().a(new a());
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
