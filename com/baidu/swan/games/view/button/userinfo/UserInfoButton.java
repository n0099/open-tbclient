package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.g94;
import com.baidu.tieba.i94;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes4.dex */
    public class a implements i94.b {
        public a() {
        }

        @Override // com.baidu.tieba.i94.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.B(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    public void B(JSONObject jSONObject) {
        g94 g94Var = new g94();
        g94Var.data = jSONObject;
        n(g94Var);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        new i94().a(new a());
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
