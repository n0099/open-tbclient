package com.baidu.adp.plugin.packageManager.pluginFileDownload;

import d.a.c.h.j.e.a;
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
    public static final long serialVersionUID = -3270428328316883061L;
    public String afterHttpDnsUrl;
    public transient a callback;
    public String check;
    public String description;
    public int errorCode;
    public int height;
    public String id;
    public long length;
    public String name;
    public int notifyId;
    public String path;
    public int position;
    public long size;
    public int status;
    public String statusMsg;
    public int type;
    public String url;
    public int width;

    public BdFileDownloadData(String str) {
        this.status = 1;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.afterHttpDnsUrl = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.id = str;
    }

    public String getAfterHttpDnsUrl() {
        return this.afterHttpDnsUrl;
    }

    public a getCallback() {
        return this.callback;
    }

    public String getCheck() {
        return this.check;
    }

    public String getDescription() {
        return this.description;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public long getLength() {
        return this.length;
    }

    public String getName() {
        return this.name;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public String getPath() {
        return this.path;
    }

    public int getPosition() {
        return this.position;
    }

    public long getSize() {
        return this.size;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public void setAfterHttpDnsUrl(String str) {
        this.afterHttpDnsUrl = str;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setCheck(String str) {
        this.check = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNotifyId(int i2) {
        this.notifyId = i2;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatusMsg(String str) {
        this.statusMsg = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public BdFileDownloadData(String str, String str2) {
        this.status = 1;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.afterHttpDnsUrl = null;
        this.callback = null;
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
        this.afterHttpDnsUrl = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.id = str;
        this.name = str2;
        this.url = str3;
        this.callback = aVar;
        this.status = 1;
    }
}
