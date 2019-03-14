package com.baidu.mapapi.map;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes5.dex */
public class MapFragment extends Fragment {
    private static final String a = MapFragment.class.getSimpleName();
    private MapView b;
    private BaiduMapOptions c;

    public MapFragment() {
    }

    private MapFragment(BaiduMapOptions baiduMapOptions) {
        this.c = baiduMapOptions;
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(BaiduMapOptions baiduMapOptions) {
        return new MapFragment(baiduMapOptions);
    }

    public BaiduMap getBaiduMap() {
        if (this.b == null) {
            return null;
        }
        return this.b.getMap();
    }

    public MapView getMapView() {
        return this.b;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = new MapView(getActivity(), this.c);
        return this.b;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.b.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.b.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.b.onResume();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
