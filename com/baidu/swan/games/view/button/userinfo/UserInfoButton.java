package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.j94;
import com.baidu.tieba.l94;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes4.dex */
    public class a implements l94.b {
        public a() {
        }

        @Override // com.baidu.tieba.l94.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.B(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    public void B(JSONObject jSONObject) {
        j94 j94Var = new j94();
        j94Var.data = jSONObject;
        n(j94Var);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        new l94().a(new a());
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
