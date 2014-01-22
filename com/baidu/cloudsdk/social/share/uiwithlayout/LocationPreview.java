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
import com.at;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.i;
import com.k;
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
        addView(LayoutInflater.from(context).inflate(i.a(context, "bdsocialshare_sharedialoglocationlayout"), (ViewGroup) null));
        this.c = (ImageView) findViewById(i.d(context, "sharedialog_location_icon"));
        this.c.setImageResource(i.c(context, "bdsocialshare_location"));
        this.e = (TextView) findViewById(i.d(context, "sharedialog_location_text"));
        this.e.setText(this.b.getString("insert_location"));
        this.d = (ImageView) findViewById(i.d(context, "sharedialog_location_delete"));
        setOnClickListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("ak", "DCd116338281e46e7ea5586305033afd");
        requestParams.put("location", String.valueOf(location.getLatitude()) + "," + String.valueOf(location.getLongitude()));
        requestParams.put("output", "json");
        requestParams.put("pois", SocialConstants.TRUE);
        new AsyncHttpClient().get(getContext(), "http://api.map.baidu.com/geocoder/v2/", requestParams, new at(this, requestParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.h = str;
        this.f = true;
        this.e.setText(str);
        this.d.setVisibility(0);
        this.c.setImageResource(i.c(getContext(), "bdsocialshare_location_enabled"));
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
