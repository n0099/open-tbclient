package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import java.io.Serializable;
/* loaded from: classes.dex */
public class BdFileDownloadData implements Serializable {
    public static final int FILE_DOWNLOAD_STATUS_CANCEL = 4;
    public static final int FILE_DOWNLOAD_STATUS_DOWNLOADING = 1;
    public static final int FILE_DOWNLOAD_STATUS_EXIST = 3;
    public static final int FILE_DOWNLOAD_STATUS_FAILED = 2;
    public static final int FILE_DOWNLOAD_STATUS_SUCEED = 0;
    public static final int FILE_DOWNLOAD_TYPE_APP = 12;
    public static final int FILE_DOWNLOAD_TYPE_EMOYION_APCKAGE = 11;
    public static final int FILE_DOWNLOAD_TYPE_NORMAL = 10;
    private static final long serialVersionUID = -3270428328316883061L;
    private transient a Gc;
    private String check;
    private String description;
    private int errorCode;
    private int height;
    private String id;
    private long length;
    private String name;
    private int notifyId;
    private String path;
    private int position;
    private long size;
    private int status;
    private String statusMsg;
    private int type;
    private String url;
    private int width;

    public BdFileDownloadData(String str) {
        this.status = 1;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.Gc = null;
        this.position = 0;
        this.notifyId = 0;
        this.id = str;
    }

    public BdFileDownloadData(String str, String str2) {
        this.status = 1;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.Gc = null;
        this.position = 0;
        this.notifyId = 0;
        this.id = str;
        this.url = str2;
    }

    public BdFileDownloadData(String str, String str2, String str3, a aVar) {
        this.status = 1;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.Gc = null;
        this.position = 0;
        this.notifyId = 0;
        this.id = str;
        this.name = str2;
        this.url = str3;
        this.Gc = aVar;
        this.status = 1;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public String getCheck() {
        return this.check;
    }

    public void setCheck(String str) {
        this.check = str;
    }

    public a getCallback() {
        return this.Gc;
    }

    public void setCallback(a aVar) {
        this.Gc = aVar;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public void setStatusMsg(String str) {
        this.statusMsg = str;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public void setNotifyId(int i) {
        this.notifyId = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }
}
