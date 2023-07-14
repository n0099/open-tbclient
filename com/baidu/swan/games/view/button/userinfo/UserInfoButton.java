package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.ue4;
import com.baidu.tieba.we4;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes4.dex */
    public class a implements we4.b {
        public a() {
        }

        @Override // com.baidu.tieba.we4.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.A(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    public void A(JSONObject jSONObject) {
        ue4 ue4Var = new ue4();
        ue4Var.data = jSONObject;
        o(ue4Var);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        new we4().a(new a());
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
