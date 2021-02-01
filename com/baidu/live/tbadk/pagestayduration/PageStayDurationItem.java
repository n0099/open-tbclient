package com.baidu.live.tbadk.pagestayduration;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter;
import java.util.List;
@Deprecated
/* loaded from: classes11.dex */
public class PageStayDurationItem implements PageStayDurationFilter.IDirtyData {
    private String currentPageKey;
    private long fid;
    public boolean isRouteStat = false;
    public String isVertical;
    public String objID;
    public String objParam1;
    private long pid;
    private List<String> sorceKeyList;
    private long stayDurationTime;
    private long tid;

    public List<String> getSorceKeyList() {
        return this.sorceKeyList;
    }

    public void setSorceKeyList(List<String> list) {
        this.sorceKeyList = list;
    }

    public String getCurrentPageKey() {
        return this.currentPageKey;
    }

    public void setCurrentPageKey(String str) {
        this.currentPageKey = str;
    }

    public long getFid() {
        return this.fid;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getTid() {
        return this.tid;
    }

    public void setTid(long j) {
        this.tid = j;
    }

    public long getPid() {
        return this.pid;
    }

    public void setPid(long j) {
        this.pid = j;
    }

    public long getStayDurationTime() {
        return this.stayDurationTime;
    }

    public void setStayDurationTime(long j) {
        this.stayDurationTime = j;
    }

    @Override // com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter.IDirtyData
    public boolean isDirtyData() {
        return StringUtils.isNull(this.currentPageKey);
    }
}
