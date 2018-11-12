package com.baidu.searchbox.ng.ai.apps.impl.map.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.searchbox.ng.ai.apps.impl.map.fragment.MapLocationFragment;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.OpenLocationMenuItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil.DrivingRouteOverlay;
import com.baidu.searchbox.ng.ai.apps.impl.map.overlayutil.MyDrivingRouteOverlay;
import com.baidu.searchbox.ng.ai.apps.impl.map.utils.DrivingRoutePlanManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class OpenLocationBottomMenu extends LinearLayout implements OpenLocationMenuItem.OnMenuItemClickListener {
    protected static final boolean DEBUG = false;
    private static final String TAG = "OpenLocationBottomMenu";
    private static DrivingRouteOverlay mRouteOverlay;
    private static boolean sItemClickFlag;
    private OpenLocationMenuItem mCancelMenu;
    private Context mContext;
    private MapLocationFragment mFragment;
    private OnGetRoutePlanResultListener mGetRoutePlanResultListener;
    private LinearLayout.LayoutParams mParams;
    private OpenLocationMenuItem mShowPath;
    private LatLng mStartPosition;

    public OpenLocationBottomMenu(Context context) {
        super(context);
        init(context);
    }

    public OpenLocationBottomMenu(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(1);
        addMenuItem();
    }

    private void addMenuItem() {
        String string;
        if (!sItemClickFlag) {
            string = this.mContext.getString(e.j.openlocation_bottommenu_showpath);
        } else {
            string = this.mContext.getString(e.j.openlocation_bottommenu_hidepath);
        }
        this.mShowPath = new OpenLocationMenuItem(this.mContext, string, OpenLocationMenuItem.MenuItemType.OPENLOCATION_PATH);
        this.mShowPath.setOnMenuItemClickListener(this);
        addView(this.mShowPath.getItem());
        this.mCancelMenu = new OpenLocationMenuItem(this.mContext, this.mContext.getString(e.j.openlocation_bottommenu_cancel), OpenLocationMenuItem.MenuItemType.OPENLOCATION_CANCEL);
        this.mCancelMenu.setOnMenuItemClickListener(this);
        this.mParams = (LinearLayout.LayoutParams) this.mCancelMenu.getItem().getLayoutParams();
        this.mParams.topMargin = AiAppsUIUtils.dp2px(7.0f);
        addView(this.mCancelMenu.getItem());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.item.OpenLocationMenuItem.OnMenuItemClickListener
    public void onMenuItemClick(OpenLocationMenuItem openLocationMenuItem) {
        if (this.mFragment != null) {
            this.mFragment.dismissPopMenu();
        }
        switch (openLocationMenuItem.getType()) {
            case OPENLOCATION_PATH:
                sItemClickFlag = !sItemClickFlag;
                if (!sItemClickFlag) {
                    hideDrivingRootPlan();
                    return;
                } else if (mRouteOverlay == null) {
                    showDrivingRoutePlan();
                    return;
                } else {
                    addRouteOverlayToMap(this.mFragment.getmBaiduMap(), mRouteOverlay);
                    this.mFragment.setFinishedShowPathFlag(true);
                    return;
                }
            default:
                return;
        }
    }

    public void setFragment(MapLocationFragment mapLocationFragment) {
        this.mFragment = mapLocationFragment;
    }

    private void showDrivingRoutePlan() {
        if (this.mFragment == null) {
            sItemClickFlag = false;
            return;
        }
        this.mFragment.setFinishedShowPathFlag(false);
        if (this.mStartPosition == null) {
            BDLocation curLocation = this.mFragment.getCurLocation();
            if (curLocation != null) {
                this.mStartPosition = new LatLng(curLocation.getLatitude(), curLocation.getLongitude());
            } else {
                return;
            }
        }
        Bundle arguments = this.mFragment.getArguments();
        LatLng latLng = new LatLng(arguments.getDouble(CoordinateModel.LATITUDE), arguments.getDouble(CoordinateModel.LONGITUDE));
        final DrivingRoutePlanManager drivingRoutePlanManager = DrivingRoutePlanManager.getInstance();
        this.mGetRoutePlanResultListener = new OnGetRoutePlanResultListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.view.OpenLocationBottomMenu.1
            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {
                drivingRoutePlanManager.destorySearch();
                if (drivingRouteResult == null || drivingRouteResult.error != SearchResult.ERRORNO.NO_ERROR || drivingRouteResult.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
                    boolean unused = OpenLocationBottomMenu.sItemClickFlag = false;
                    return;
                }
                BaiduMap baiduMap = OpenLocationBottomMenu.this.mFragment.getmBaiduMap();
                if (baiduMap == null) {
                    boolean unused2 = OpenLocationBottomMenu.sItemClickFlag = false;
                } else if (OpenLocationBottomMenu.sItemClickFlag) {
                    DrivingRouteOverlay unused3 = OpenLocationBottomMenu.mRouteOverlay = new MyDrivingRouteOverlay(baiduMap);
                    baiduMap.setOnMarkerClickListener(OpenLocationBottomMenu.mRouteOverlay);
                    OpenLocationBottomMenu.mRouteOverlay.setData(drivingRouteResult.getRouteLines().get(0));
                    OpenLocationBottomMenu.mRouteOverlay.addToMap();
                    OpenLocationBottomMenu.mRouteOverlay.zoomToSpan();
                    OpenLocationBottomMenu.this.mFragment.setFinishedShowPathFlag(true);
                }
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {
            }

            @Override // com.baidu.mapapi.search.route.OnGetRoutePlanResultListener
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {
            }
        };
        if (this.mStartPosition == null) {
            sItemClickFlag = false;
        } else {
            drivingRoutePlanManager.startRoutePlan(this.mStartPosition, latLng, this.mGetRoutePlanResultListener);
        }
    }

    private void hideDrivingRootPlan() {
        if (this.mFragment != null && this.mFragment.getFinishedShowPathFlag() && mRouteOverlay != null) {
            mRouteOverlay.removeFromMap();
        }
    }

    public static void resetItemClickFlag() {
        sItemClickFlag = false;
        mRouteOverlay = null;
    }

    private void addRouteOverlayToMap(BaiduMap baiduMap, DrivingRouteOverlay drivingRouteOverlay) {
        if (baiduMap != null && drivingRouteOverlay != null) {
            baiduMap.setOnMarkerClickListener(drivingRouteOverlay);
            drivingRouteOverlay.addToMap();
            drivingRouteOverlay.zoomToSpan();
        }
    }
}
