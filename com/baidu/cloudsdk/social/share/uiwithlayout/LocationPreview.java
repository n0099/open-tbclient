package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.p;
import com.q;
import com.s;
/* loaded from: classes.dex */
public class LocationPreview extends RelativeLayout {
    private static final String a = LocationPreview.class.getSimpleName();
    private SocialShareConfig b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private boolean f;
    private Location g;
    private String h;

    public LocationPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.b = SocialShareConfig.getInstance(context);
        addView(LayoutInflater.from(context.getApplicationContext()).inflate(p.g(context, "bdsocialshare_sharedialoglocationlayout"), (ViewGroup) null));
        this.c = (ImageView) findViewById(p.j(context, "sharedialog_location_icon"));
        this.c.setImageResource(p.i(context, "bdsocialshare_location"));
        this.e = (TextView) findViewById(p.j(context, "sharedialog_location_text"));
        this.e.setText(this.b.getString("insert_location"));
        this.d = (ImageView) findViewById(p.j(context, "sharedialog_location_delete"));
        setOnClickListener(new q(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("ak", "DCd116338281e46e7ea5586305033afd");
        requestParams.put("location", String.valueOf(location.getLatitude()) + "," + String.valueOf(location.getLongitude()));
        requestParams.put("output", "json");
        requestParams.put("pois", "1");
        new AsyncHttpClient().get(getContext(), "http://api.map.baidu.com/geocoder/v2/", requestParams, new s(this, requestParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.h = str;
        this.f = true;
        this.e.setText(str);
        this.d.setVisibility(0);
        this.c.setImageResource(p.i(getContext(), "bdsocialshare_location_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f = false;
        this.h = null;
        this.e.setText(this.b.getString("unknown_street"));
        this.d.setVisibility(8);
        Toast.makeText(getContext(), this.b.getString("get_location_failed"), 0).show();
    }

    public Location getLocation() {
        return this.g;
    }

    public boolean isChecked() {
        return this.f;
    }

    public void setLocation(Location location) {
        if (location == null) {
            this.f = false;
            this.h = null;
            this.d.setVisibility(8);
            return;
        }
        this.g = location;
        this.e.setText(this.b.getString("get_location"));
        a(location);
    }
}
