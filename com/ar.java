package com;

import android.location.Location;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.common.util.PositionManager;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.uiwithlayout.LocationPreview;
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ LocationPreview a;

    public ar(LocationPreview locationPreview) {
        this.a = locationPreview;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        TextView textView;
        SocialShareConfig socialShareConfig;
        Location location;
        Location location2;
        String str2;
        TextView textView2;
        SocialShareConfig socialShareConfig2;
        ImageView imageView;
        z = this.a.f;
        if (z) {
            this.a.f = false;
            textView2 = this.a.e;
            socialShareConfig2 = this.a.b;
            textView2.setText(socialShareConfig2.getString("insert_location"));
            imageView = this.a.d;
            imageView.setVisibility(8);
            return;
        }
        str = this.a.h;
        if (!TextUtils.isEmpty(str)) {
            LocationPreview locationPreview = this.a;
            str2 = this.a.h;
            locationPreview.a(str2);
            return;
        }
        textView = this.a.e;
        socialShareConfig = this.a.b;
        textView.setText(socialShareConfig.getString("get_location"));
        location = this.a.g;
        if (location != null) {
            LocationPreview locationPreview2 = this.a;
            location2 = this.a.g;
            locationPreview2.a(location2);
            return;
        }
        try {
            if (this.a.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                new PositionManager(this.a.getContext()).requestLoation(new as(this));
            }
        } catch (Exception e) {
        }
    }
}
