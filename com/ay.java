package com;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.restapi.SocialRestAPIImpl;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import com.baidu.cloudsdk.social.share.uiwithlayout.SwitchButton;
import java.util.List;
/* loaded from: classes.dex */
public class ay extends ArrayAdapter {
    private a a;
    private SocialShareConfig b;

    /* loaded from: classes.dex */
    public interface a {
        void onCheckStatusChanged(boolean z, MediaType mediaType);
    }

    /* loaded from: classes.dex */
    class b {
        private ImageView b;
        private TextView c;
        private TextView d;
        private SwitchButton e;

        private b() {
        }

        /* synthetic */ b(ay ayVar, az azVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(Context context, List list, a aVar) {
        super(context, 0, list);
        int i = 0;
        this.a = aVar;
        this.b = SocialShareConfig.getInstance(context);
        String string = this.b.getString("unbind");
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            ShareMediaItem shareMediaItem = (ShareMediaItem) list.get(i2);
            if (shareMediaItem.isAuthorized() && !TextUtils.isEmpty(shareMediaItem.getUserName())) {
                a(context, shareMediaItem);
            } else if (!shareMediaItem.isAuthorized()) {
                shareMediaItem.setUserName(string);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareMediaItem shareMediaItem, boolean z) {
        shareMediaItem.setAuthorized(z);
        shareMediaItem.setChecked(z);
        if (z) {
            a(getContext(), shareMediaItem);
            this.a.onCheckStatusChanged(true, shareMediaItem.getMediaType());
        }
        notifyDataSetChanged();
    }

    protected void a(Context context, ShareMediaItem shareMediaItem) {
        new SocialRestAPIImpl(context).getUserInfo(shareMediaItem.getMediaType().toString(), new bb(this, shareMediaItem));
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            bVar = new b(this, null);
            view = LayoutInflater.from(getContext()).inflate(aq.a(getContext(), "bdsocialshare_sharedialogmediaitemlayout"), (ViewGroup) null);
            bVar.b = (ImageView) view.findViewById(aq.d(getContext(), "sharedialog_mediaitem_iconview"));
            bVar.c = (TextView) view.findViewById(aq.d(getContext(), "sharedialog_mediaitem_nameview"));
            bVar.c.setTextColor(Color.parseColor(aq.a(getContext())));
            bVar.d = (TextView) view.findViewById(aq.d(getContext(), "sharedialog_mediaitem_desview"));
            bVar.d.setTextColor(Color.parseColor(aq.i(getContext())));
            bVar.e = (SwitchButton) view.findViewById(aq.d(getContext(), "sharedialog_mediaitem_switchbutton"));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        ShareMediaItem shareMediaItem = (ShareMediaItem) getItem(i);
        bVar.b.setImageResource(shareMediaItem.isChecked() ? aq.c(getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString()) : aq.c(getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString() + "_gray"));
        bVar.c.setText(this.b.getString(shareMediaItem.getMediaType().toString()));
        bVar.d.setText(shareMediaItem.getUserName());
        bVar.e.setTag(shareMediaItem);
        bVar.e.setOnCheckedChangeListener(new az(this, bVar));
        bVar.e.setChecked(shareMediaItem.isChecked());
        return view;
    }
}
