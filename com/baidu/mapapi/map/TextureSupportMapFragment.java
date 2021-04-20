package com.baidu.mapapi.map;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
/* loaded from: classes2.dex */
public class TextureSupportMapFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7066a = TextureSupportMapFragment.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public TextureMapView f7067b;

    /* renamed from: c  reason: collision with root package name */
    public BaiduMapOptions f7068c;

    public TextureSupportMapFragment() {
    }

    public TextureSupportMapFragment(BaiduMapOptions baiduMapOptions) {
        this.f7068c = baiduMapOptions;
    }

    public static TextureSupportMapFragment newInstance() {
        return new TextureSupportMapFragment();
    }

    public static TextureSupportMapFragment newInstance(BaiduMapOptions baiduMapOptions) {
        return new TextureSupportMapFragment(baiduMapOptions);
    }

    public BaiduMap getBaiduMap() {
        TextureMapView textureMapView = this.f7067b;
        if (textureMapView == null) {
            return null;
        }
        return textureMapView.getMap();
    }

    public TextureMapView getMapView() {
        return this.f7067b;
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
        TextureMapView textureMapView = new TextureMapView(getActivity(), this.f7068c);
        this.f7067b = textureMapView;
        return textureMapView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f7067b.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f7067b.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f7067b.onResume();
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
    }
}
