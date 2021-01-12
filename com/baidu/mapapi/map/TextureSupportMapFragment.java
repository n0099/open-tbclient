package com.baidu.mapapi.map;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
/* loaded from: classes6.dex */
public class TextureSupportMapFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2774a = TextureSupportMapFragment.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private TextureMapView f2775b;
    private BaiduMapOptions c;

    public TextureSupportMapFragment() {
    }

    private TextureSupportMapFragment(BaiduMapOptions baiduMapOptions) {
        this.c = baiduMapOptions;
    }

    public static TextureSupportMapFragment newInstance() {
        return new TextureSupportMapFragment();
    }

    public static TextureSupportMapFragment newInstance(BaiduMapOptions baiduMapOptions) {
        return new TextureSupportMapFragment(baiduMapOptions);
    }

    public BaiduMap getBaiduMap() {
        if (this.f2775b == null) {
            return null;
        }
        return this.f2775b.getMap();
    }

    public TextureMapView getMapView() {
        return this.f2775b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2775b = new TextureMapView(getActivity(), this.c);
        return this.f2775b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f2775b.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f2775b.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f2775b.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle == null) {
        }
    }
}
