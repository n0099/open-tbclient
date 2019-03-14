package com.baidu.platform.comjni.bikenavi;

import android.os.Bundle;
/* loaded from: classes5.dex */
public class JNIGuidanceControl {
    public native int CalcRoute(long j, int i, int i2, int i3, byte[] bArr);

    public native boolean GetCarPoint(long j, int[] iArr, int[] iArr2);

    public native int GetCurCorrectDirection(long j);

    public native boolean GetFirstParagraph(long j, Bundle bundle);

    public native boolean GetGuideParagraph(long j, int i, int i2, Bundle bundle);

    public native boolean GetNaviRouteBoundWithNoMargin(long j, Bundle bundle);

    public native boolean GetParagraphBound(long j, int i, Bundle bundle);

    public native boolean GetRouteResult(long j, int i, Bundle bundle);

    public native boolean GetSimpleMapInfo(long j, Bundle bundle);

    public native boolean GetTravelData(long j, Bundle bundle);

    public native boolean IsBrowseStatus(long j);

    public native boolean PauseRouteGuide(long j);

    public native boolean PrepareRouteGuide(long j);

    public native void ResumeReRouteCalcRoute(long j);

    public native boolean ResumeRouteGuide(long j);

    public native boolean SetBrowseStatus(long j, boolean z);

    public native void SetGuideTextMaxWordCnt(long j, int i);

    public native boolean SetLocateMode(long j, int i);

    public native boolean SetNaviType(long j, int i);

    public native boolean SetNetStatistics(long j, String str);

    public native void SetParagraphFocus(long j, int i);

    public native boolean SetRotateMode(long j, int i);

    public native boolean SetVehiclePos(long j, int i, int i2, int i3);

    public native void ShowNPCModel(long j, boolean z);

    public native boolean StartRouteGuide(long j);

    public native boolean StopRouteGuide(long j);

    public native boolean TriggerGPSDataChange(long j, double d, double d2, float f, float f2, float f3, float f4, String str, String str2, int i, int i2);

    public native void UpdateSensor(long j, double d, double d2, double d3, double d4, double d5, double d6);

    public native boolean getCurViaPoiPanoImage(long j, Bundle bundle);

    public native boolean getTrafficFacilities(long j, int[] iArr, int[] iArr2, int[] iArr3);

    public native int getTrafficFacilitiesNum(long j);

    public native boolean getViaNaviNodes(long j, int[] iArr, int[] iArr2, int[] iArr3);

    public native void needShowPoiPanoImage(long j, boolean z);

    public native void registerGetLaunchSystemTime(long j);

    public native boolean setARRouteResID(long j, int i, int i2);

    public native boolean setNaviMode(long j, int i);

    public native boolean setNaviNodes(long j, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, String[] strArr, String[] strArr2);

    public native boolean setOriNaviOverlooking(long j, int i);
}
