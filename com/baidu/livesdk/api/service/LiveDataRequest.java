package com.baidu.livesdk.api.service;

import java.util.List;
/* loaded from: classes2.dex */
public interface LiveDataRequest {

    /* loaded from: classes2.dex */
    public static class LiveData {
        public String content;
        public String roomId;

        public LiveData(String str, String str2) {
            this.roomId = str;
            this.content = str2;
        }

        public String getContent() {
            return this.content;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setRoomId(String str) {
            this.roomId = str;
        }
    }

    /* loaded from: classes2.dex */
    public interface PageDataReceiver {
        void onReceiver(PageData pageData);
    }

    /* loaded from: classes2.dex */
    public static class PageInfo {
        public int page;
        public int pageSize;

        public PageInfo(int i2, int i3) {
            this.page = i2;
            this.pageSize = i3;
        }

        public int getPage() {
            return this.page;
        }

        public int getPageSize() {
            return this.pageSize;
        }

        public void setPage(int i2) {
            this.page = i2;
        }

        public void setPageSize(int i2) {
            this.pageSize = i2;
        }
    }

    void queryPageData(String str, Integer num, Integer num2, PageDataReceiver pageDataReceiver);

    void release();

    /* loaded from: classes2.dex */
    public static class PageData {
        public String errno;
        public List<LiveData> liveDatas;
        public String message;
        public PageInfo pageInfo;

        public PageData(String str, String str2) {
            this.errno = str;
            this.message = str2;
        }

        public String getErrno() {
            return this.errno;
        }

        public List<LiveData> getLiveDatas() {
            return this.liveDatas;
        }

        public String getMessage() {
            return this.message;
        }

        public PageInfo getPageInfo() {
            return this.pageInfo;
        }

        public void setErrno(String str) {
            this.errno = str;
        }

        public void setLiveDatas(List<LiveData> list) {
            this.liveDatas = list;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setPageInfo(PageInfo pageInfo) {
            this.pageInfo = pageInfo;
        }

        public PageData(String str, List<LiveData> list, PageInfo pageInfo) {
            this.errno = str;
            this.liveDatas = list;
            this.pageInfo = pageInfo;
        }
    }
}
