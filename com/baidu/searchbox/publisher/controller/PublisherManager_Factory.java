package com.baidu.searchbox.publisher.controller;
/* loaded from: classes5.dex */
public class PublisherManager_Factory {
    private static volatile PublisherManager instance;

    private PublisherManager_Factory() {
    }

    public static synchronized PublisherManager get() {
        PublisherManager publisherManager;
        synchronized (PublisherManager_Factory.class) {
            if (instance == null) {
                instance = new PublisherManager();
            }
            publisherManager = instance;
        }
        return publisherManager;
    }
}
