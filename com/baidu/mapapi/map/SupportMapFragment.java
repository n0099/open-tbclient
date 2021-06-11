package com.baidu.mapapi.map;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
/* loaded from: classes2.dex */
public class SupportMapFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7035a = SupportMapFragment.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public MapView f7036b;

    /* renamed from: c  reason: collision with root package name */
    public BaiduMapOptions f7037c;

    public SupportMapFragment() {
    }

    public SupportMapFragment(BaiduMapOptions baiduMapOptions) {
        this.f7037c = baiduMapOptions;
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(BaiduMapOptions baiduMapOptions) {
        return new SupportMapFragment(baiduMapOptions);
    }

    public BaiduMap getBaiduMap() {
        MapView mapView = this.f7036b;
        if (mapView == null) {
            return null;
        }
        return mapView.getMap();
    }

    public MapView getMapView() {
        return this.f7036b;
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
        MapView mapView = new MapView(getActivity(), this.f7037c);
        this.f7036b = mapView;
        return mapView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f7036b.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f7036b.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f7036b.onResume();
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
