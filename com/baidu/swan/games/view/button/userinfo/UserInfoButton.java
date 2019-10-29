package com.baidu.swan.games.view.button.userinfo;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.swan.games.view.button.userinfo.c;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UserInfoButton extends ApiButton {
    public UserInfoButton(Context context) {
        super(context);
    }

    public UserInfoButton(Context context, EventTargetImpl eventTargetImpl) {
        super(context, eventTargetImpl);
    }

    @Override // com.baidu.swan.games.view.button.base.ApiButton, android.view.View.OnClickListener
    public void onClick(View view) {
        new c().a(new c.a() { // from class: com.baidu.swan.games.view.button.userinfo.UserInfoButton.1
            @Override // com.baidu.swan.games.view.button.userinfo.c.a
            public void aW(JSONObject jSONObject) {
                UserInfoButton.this.aV(jSONObject);
            }
        });
    }

    public void aV(JSONObject jSONObject) {
        a aVar = new a();
        aVar.data = jSONObject;
        a(aVar);
    }
}
