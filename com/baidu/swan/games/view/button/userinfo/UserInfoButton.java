package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.lc4;
import com.baidu.tieba.nc4;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserInfoButton extends ApiButton {

    /* loaded from: classes3.dex */
    public class a implements nc4.b {
        public a() {
        }

        @Override // com.baidu.tieba.nc4.b
        public void a(JSONObject jSONObject) {
            UserInfoButton.this.u(jSONObject);
        }
    }

    public UserInfoButton(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view2) {
        new nc4().a(new a());
    }

    public void u(JSONObject jSONObject) {
        lc4 lc4Var = new lc4();
        lc4Var.data = jSONObject;
        k(lc4Var);
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }
}
